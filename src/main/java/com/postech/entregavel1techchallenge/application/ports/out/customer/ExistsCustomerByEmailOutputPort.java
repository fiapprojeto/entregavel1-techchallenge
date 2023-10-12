package com.postech.entregavel1techchallenge.application.ports.out.customer;

public interface ExistsCustomerByEmailOutputPort {
    boolean exists(String email);
}
