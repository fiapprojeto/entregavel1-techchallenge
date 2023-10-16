package com.postech.entregavel1techchallenge.application.core.service.order;

import com.postech.entregavel1techchallenge.application.core.domain.order.enums.OrderStatusEnum;
import com.postech.entregavel1techchallenge.application.core.exceptions.order.InvalidOrderStatusException;
import com.postech.entregavel1techchallenge.application.core.exceptions.order.InvalidTotalToPayOrderException;
import com.postech.entregavel1techchallenge.application.core.exceptions.order.OrderNotFoundException;
import com.postech.entregavel1techchallenge.application.ports.in.order.PayOrderInputPort;
import com.postech.entregavel1techchallenge.application.ports.out.order.GetOrderByIdOutputPort;
import com.postech.entregavel1techchallenge.application.ports.out.order.UpdateOrderOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class PayOrderService implements PayOrderInputPort {

    private final GetOrderByIdOutputPort getOrderByIdOutputPort;

    private final UpdateOrderOutputPort updateOrderOutputPort;

    @Override
    public void pay(String orderId, BigDecimal total) {
        var order = getOrderByIdOutputPort.get(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Pedido não encontrado para seguir com pagamento."));

        if(!OrderStatusEnum.CREATED.equals(order.getStatus()))
            throw new InvalidOrderStatusException("Status inválido para seguir com o pagamento do pedido.");

        if(order.getTotal().compareTo(total) != 0)
            throw new InvalidTotalToPayOrderException("Valor de pagamento inválido para esse pedido.");

        order.setStatus(OrderStatusEnum.PAID);

        updateOrderOutputPort.update(order);
    }
}
