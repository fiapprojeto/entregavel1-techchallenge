package com.postech.entregavel1techchallenge.application.ports.out.customer;


import com.postech.entregavel1techchallenge.application.core.domain.customer.Customer;

public interface SaveCustomerOutPort {
    Customer save(Customer customer);
}
