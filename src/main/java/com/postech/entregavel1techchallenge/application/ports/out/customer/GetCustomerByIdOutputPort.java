package com.postech.entregavel1techchallenge.application.ports.out.customer;

import com.postech.entregavel1techchallenge.application.core.domain.customer.Customer;

import java.util.Optional;

public interface GetCustomerByIdOutputPort {

    Optional<Customer> get(String id);
}
