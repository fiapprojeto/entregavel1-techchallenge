package com.postech.entregavel1techchallenge.adapters.out.customer;

import com.postech.entregavel1techchallenge.adapters.out.repository.CustomerRepository;
import com.postech.entregavel1techchallenge.application.ports.out.customer.ExistsCustomerByDocumentOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ExistsCustomerByDocumentAdapter implements ExistsCustomerByDocumentOutputPort {

    private final CustomerRepository customerRepository;

    @Override
    @Transactional(readOnly = true)
    public boolean exists(String document) {
        return customerRepository.existsByDocument(document);
    }
}
