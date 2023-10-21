package com.postech.entregavel1techchallenge.application.ports.in.order;

import com.postech.entregavel1techchallenge.application.core.domain.order.Order;
import com.postech.entregavel1techchallenge.application.core.domain.order.enums.OrderProgressEnum;

import java.util.List;

public interface FindOrdersByProgressInputPort {

    List<Order> get(OrderProgressEnum orderProgressEnum);
}
