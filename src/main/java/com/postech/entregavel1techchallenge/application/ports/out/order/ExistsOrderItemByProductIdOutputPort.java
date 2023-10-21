package com.postech.entregavel1techchallenge.application.ports.out.order;

public interface ExistsOrderItemByProductIdOutputPort {

    boolean exists(String productId);
}
