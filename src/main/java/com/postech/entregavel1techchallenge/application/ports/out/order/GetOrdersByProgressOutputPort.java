package com.postech.entregavel1techchallenge.application.ports.out.order;

import com.postech.entregavel1techchallenge.application.core.domain.order.Order;

import java.util.List;

public interface GetOrdersByProgressOutputPort {

    List<Order> get(String progress);

}
