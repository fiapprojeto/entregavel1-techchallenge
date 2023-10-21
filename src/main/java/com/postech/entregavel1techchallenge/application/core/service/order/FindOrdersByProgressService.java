package com.postech.entregavel1techchallenge.application.core.service.order;

import com.postech.entregavel1techchallenge.application.core.domain.order.Order;
import com.postech.entregavel1techchallenge.application.core.domain.order.enums.OrderProgressEnum;
import com.postech.entregavel1techchallenge.application.ports.in.order.FindOrdersByProgressInputPort;
import com.postech.entregavel1techchallenge.application.ports.out.order.GetOrdersByProgressOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindOrdersByProgressService implements FindOrdersByProgressInputPort {

    private final GetOrdersByProgressOutputPort getOrdersByProgressOutputPort;

    @Override
    public List<Order> get(OrderProgressEnum orderProgressEnum) {
        return getOrdersByProgressOutputPort.get(orderProgressEnum.toString());
    }
}
