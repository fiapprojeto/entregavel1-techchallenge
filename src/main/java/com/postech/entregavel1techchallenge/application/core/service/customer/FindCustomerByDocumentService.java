package com.postech.entregavel1techchallenge.application.core.service.customer;

import com.postech.entregavel1techchallenge.application.core.domain.Customer;
import com.postech.entregavel1techchallenge.application.core.exceptions.customer.CustomerNotFoundException;
import com.postech.entregavel1techchallenge.application.ports.in.customer.FindCustomerByDocumentInputPort;
import com.postech.entregavel1techchallenge.application.ports.out.customer.GetCustomerByDocumentOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindCustomerByDocumentService implements FindCustomerByDocumentInputPort {

    private final GetCustomerByDocumentOutputPort getCustomerByDocumentOutputPort;

    @Override
    public Customer find(String document) {
        return getCustomerByDocumentOutputPort.get(document)
                .orElseThrow(() -> new CustomerNotFoundException("Cliente não encontrado para o documento informado."));
    }
}
