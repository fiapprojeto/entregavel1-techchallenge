package com.postech.entregavel1techchallenge.application.ports.in.order;

import java.math.BigDecimal;

public interface PayOrderInputPort {
    void pay(String orderId, BigDecimal total);
}
