package com.postech.entregavel1techchallenge.application.core.service.order;

import com.postech.entregavel1techchallenge.application.core.domain.order.enums.OrderStatusEnum;
import com.postech.entregavel1techchallenge.application.core.exceptions.order.InvalidOrderStatusException;
import com.postech.entregavel1techchallenge.application.core.exceptions.order.NotFoundOrderException;
import com.postech.entregavel1techchallenge.application.ports.in.order.CancelOrderInputPort;
import com.postech.entregavel1techchallenge.application.ports.out.order.GetOrderByIdOutputPort;
import com.postech.entregavel1techchallenge.application.ports.out.order.UpdateOrderOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CancelOrderService implements CancelOrderInputPort {

    private final GetOrderByIdOutputPort getOrderByIdOutputPort;

    private final UpdateOrderOutputPort updateOrderOutputPort;

    @Override
    public void cancel(String orderId) {
        var order = getOrderByIdOutputPort.get(orderId)
                .orElseThrow(() -> new NotFoundOrderException("Pedido não encontrado para seguir com cancelamento."));

        if(!OrderStatusEnum.CREATED.equals(order.getStatus()))
            throw new InvalidOrderStatusException("Status inválido para cancelar pedido.");

        order.setStatus(OrderStatusEnum.CANCELED);

        updateOrderOutputPort.update(order);
    }
}
