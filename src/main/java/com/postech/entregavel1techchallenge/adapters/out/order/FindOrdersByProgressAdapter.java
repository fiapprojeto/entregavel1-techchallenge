package com.postech.entregavel1techchallenge.adapters.out.order;

import com.postech.entregavel1techchallenge.adapters.out.repository.OrderRepository;
import com.postech.entregavel1techchallenge.adapters.out.repository.mapper.OrderEntityMapper;
import com.postech.entregavel1techchallenge.application.core.domain.order.Order;
import com.postech.entregavel1techchallenge.application.ports.out.order.GetOrdersByProgressOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindOrdersByProgressAdapter implements GetOrdersByProgressOutputPort {

    private final OrderRepository orderRepository;

    private final OrderEntityMapper entityMapper;

    private final static String PAID = "PAID";

    @Override
    public List<Order> get(String progress) {
        return orderRepository.findByProgressAndStatus(progress, PAID).stream()
                .map(entityMapper::toOrder)
                .toList();
    }
}
