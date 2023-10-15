package com.postech.entregavel1techchallenge.adapters.out.order;

import com.postech.entregavel1techchallenge.adapters.out.repository.OrderRepository;
import com.postech.entregavel1techchallenge.adapters.out.repository.mapper.OrderEntityMapper;
import com.postech.entregavel1techchallenge.application.core.domain.order.Order;
import com.postech.entregavel1techchallenge.application.ports.out.order.UpdateOrderOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UpdateOrderAdapter implements UpdateOrderOutputPort {

    private final OrderRepository orderRepository;

    private final OrderEntityMapper entityMapper;

    @Override
    @Transactional
    public Order update(Order order) {
        var orderEntity = entityMapper.toOrderEntity(order);
        orderRepository.save(orderEntity);
        return entityMapper.toOrder(orderEntity);
    }
}
