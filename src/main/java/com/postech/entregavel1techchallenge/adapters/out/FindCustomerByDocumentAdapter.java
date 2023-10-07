package com.postech.entregavel1techchallenge.adapters.out;

import com.postech.entregavel1techchallenge.adapters.out.repository.CustomerRepository;
import com.postech.entregavel1techchallenge.adapters.out.repository.entity.CustomerEntity;
import com.postech.entregavel1techchallenge.adapters.out.repository.mapper.CustomerEntityMapper;
import com.postech.entregavel1techchallenge.application.core.domain.Customer;
import com.postech.entregavel1techchallenge.application.ports.out.GetCustomerByDocumentOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindCustomerByDocumentAdapter implements GetCustomerByDocumentOutputPort {

    private final CustomerRepository customerRepository;

    private final CustomerEntityMapper entityMapper;

    @Override
    @Transactional(readOnly = true)
    public Optional<Customer> get(String document) {
        var customerEntity = customerRepository.findByDocument(document);
        return customerEntity.map(entityMapper::toCustomer);
    }
}
