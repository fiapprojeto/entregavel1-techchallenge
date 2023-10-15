package com.postech.entregavel1techchallenge.adapters.out.order;


import com.postech.entregavel1techchallenge.adapters.out.repository.OrderItemRepository;
import com.postech.entregavel1techchallenge.adapters.out.repository.OrderRepository;
import com.postech.entregavel1techchallenge.adapters.out.repository.mapper.OrderEntityMapper;
import com.postech.entregavel1techchallenge.application.core.domain.order.Order;
import com.postech.entregavel1techchallenge.application.ports.out.order.CreateOrderOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class SaveOrderAdapter implements CreateOrderOutputPort {

    private final OrderRepository orderRepository;

    private final OrderItemRepository orderItemRepository;

    private final OrderEntityMapper entityMapper;

    @Override
    @Transactional
    public Order create(Order order) {
        var orderEntity = entityMapper.toOrderEntity(order);
        orderRepository.save(orderEntity);

        for (var orderItem : orderEntity.getItems()) {
            orderItem.setOrder(orderEntity);
        }

        orderItemRepository.saveAll(orderEntity.getItems());


        return entityMapper.toOrder(orderEntity);
    }
}
