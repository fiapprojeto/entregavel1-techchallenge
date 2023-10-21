package com.postech.entregavel1techchallenge.application.core.service.order;


import com.postech.entregavel1techchallenge.application.core.domain.order.enums.OrderProgressEnum;
import com.postech.entregavel1techchallenge.application.core.domain.order.enums.OrderStatusEnum;
import com.postech.entregavel1techchallenge.application.core.exceptions.order.InvalidOrderStatusException;
import com.postech.entregavel1techchallenge.application.core.exceptions.order.OrderNotFoundException;
import com.postech.entregavel1techchallenge.application.ports.in.order.ChangeProgressOrderInputPort;
import com.postech.entregavel1techchallenge.application.ports.out.order.GetOrderByIdOutputPort;
import com.postech.entregavel1techchallenge.application.ports.out.order.UpdateOrderOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangeProgressOrderService implements ChangeProgressOrderInputPort {

    private final GetOrderByIdOutputPort getOrderByIdOutputPort;

    private final UpdateOrderOutputPort updateOrderOutputPort;

    @Override
    public void change(String orderId) {

        var order = getOrderByIdOutputPort.get(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Pedido não encontrado."));

        if(!OrderStatusEnum.PAID.equals(order.getStatus()))
            throw new InvalidOrderStatusException("Somente pedidos pagos podem dar andamento.");

        if(OrderProgressEnum.FINALIZADO.equals(order.getProgress()))
            throw new InvalidOrderStatusException("Pedido já encontra-se finalizado.");

        var currentProgressIndex = order.getProgress().ordinal();
        var nextProgressIndex = currentProgressIndex + 1;
        var orderProgress = OrderProgressEnum.values()[nextProgressIndex];
        order.setProgress(orderProgress);
        updateOrderOutputPort.update(order);
    }
}
