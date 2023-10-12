package com.postech.entregavel1techchallenge.application.ports.in.customer;

import com.postech.entregavel1techchallenge.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);

}
