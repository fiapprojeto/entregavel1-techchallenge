package com.postech.entregavel1techchallenge.application.ports.in;

import com.postech.entregavel1techchallenge.application.core.domain.Customer;

public interface FindCustomerByDocumentInputPort {
    Customer find(String document);
}
