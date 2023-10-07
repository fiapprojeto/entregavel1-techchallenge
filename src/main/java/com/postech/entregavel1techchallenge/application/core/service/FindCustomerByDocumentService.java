package com.postech.entregavel1techchallenge.application.core.service;

import com.postech.entregavel1techchallenge.application.core.domain.Customer;
import com.postech.entregavel1techchallenge.application.core.exceptions.CustomerNotFoundException;
import com.postech.entregavel1techchallenge.application.ports.in.FindCustomerByDocumentInputPort;
import com.postech.entregavel1techchallenge.application.ports.out.GetCustomerByDocumentOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindCustomerByDocumentService implements FindCustomerByDocumentInputPort {

    private final GetCustomerByDocumentOutputPort getCustomerByDocumentOutputPort;

    @Override
    public Customer find(String document) {
        return getCustomerByDocumentOutputPort.get(document)
                .orElseThrow(() -> new CustomerNotFoundException("Cliente não encontrado."));
    }
}
