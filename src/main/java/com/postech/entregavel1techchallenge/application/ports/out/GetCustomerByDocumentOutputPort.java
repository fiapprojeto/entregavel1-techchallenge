package com.postech.entregavel1techchallenge.application.ports.out;

import com.postech.entregavel1techchallenge.application.core.domain.Customer;

import java.util.Optional;

public interface GetCustomerByDocumentOutputPort {

    Optional<Customer> get(String document);
}
