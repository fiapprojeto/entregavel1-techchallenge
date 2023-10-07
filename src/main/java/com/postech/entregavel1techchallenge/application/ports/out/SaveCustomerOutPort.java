package com.postech.entregavel1techchallenge.application.ports.out;

import com.postech.entregavel1techchallenge.application.core.domain.Customer;

public interface SaveCustomerOutPort {
    Customer save(Customer customer);
}
