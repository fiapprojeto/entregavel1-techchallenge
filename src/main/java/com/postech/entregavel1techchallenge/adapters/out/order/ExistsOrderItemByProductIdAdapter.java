package com.postech.entregavel1techchallenge.adapters.out.order;

import com.postech.entregavel1techchallenge.adapters.out.repository.OrderItemRepository;
import com.postech.entregavel1techchallenge.application.ports.out.order.ExistsOrderItemByProductIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExistsOrderItemByProductIdAdapter implements ExistsOrderItemByProductIdOutputPort {

    private final OrderItemRepository orderItemRepository;
    @Override
    public boolean exists(String productId) {
        return orderItemRepository.existsByProduct_Id(productId);
    }
}
