package com.postech.entregavel1techchallenge.application.ports.out.order;

import com.postech.entregavel1techchallenge.application.core.domain.order.Order;

public interface UpdateOrderOutputPort {
    Order update(Order order);
}
