package com.postech.entregavel1techchallenge.adapters.out.order;

import com.postech.entregavel1techchallenge.adapters.out.repository.OrderRepository;
import com.postech.entregavel1techchallenge.adapters.out.repository.mapper.OrderEntityMapper;
import com.postech.entregavel1techchallenge.application.core.domain.order.Order;
import com.postech.entregavel1techchallenge.application.ports.out.order.GetOrderByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindOrderByIdAdapter implements GetOrderByIdOutputPort {

    private final OrderRepository orderRepository;

    private final OrderEntityMapper entityMapper;

    @Override
    public Optional<Order> get(String orderId) {
        return orderRepository.findById(orderId)
                .map(entityMapper::toOrder);
    }
}
