package com.postech.entregavel1techchallenge.adapters.out.order;

import com.postech.entregavel1techchallenge.adapters.out.repository.OrderRepository;
import com.postech.entregavel1techchallenge.adapters.out.repository.entity.OrderEntity;
import com.postech.entregavel1techchallenge.adapters.out.repository.mapper.OrderEntityMapper;
import com.postech.entregavel1techchallenge.application.core.domain.order.Order;
import com.postech.entregavel1techchallenge.application.ports.out.order.UpdateOrderOutputPort;
import com.postech.entregavel1techchallenge.config.mapper.ModelMapperCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UpdateOrderAdapter implements UpdateOrderOutputPort {

    private final OrderRepository orderRepository;

    private final ModelMapperCustom mapper;

    @Override
    @Transactional
    public Order update(Order order) {
        var orderEntity = mapper.map(order, OrderEntity.class);
        orderRepository.save(orderEntity);
        return mapper.map(orderEntity, Order.class);
    }
}
