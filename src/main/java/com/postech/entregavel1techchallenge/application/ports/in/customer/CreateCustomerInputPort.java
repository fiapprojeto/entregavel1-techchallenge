package com.postech.entregavel1techchallenge.application.ports.in.customer;


import com.postech.entregavel1techchallenge.application.core.domain.customer.Customer;

public interface CreateCustomerInputPort {
    Customer save(Customer customer);
}
