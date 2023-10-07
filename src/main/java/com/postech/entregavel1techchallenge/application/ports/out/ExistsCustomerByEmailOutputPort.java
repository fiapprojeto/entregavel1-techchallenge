package com.postech.entregavel1techchallenge.application.ports.out;

public interface ExistsCustomerByEmailOutputPort {
    boolean exists(String email);
}
