package com.postech.entregavel1techchallenge.adapters.out.customer;

import com.postech.entregavel1techchallenge.adapters.out.repository.CustomerRepository;
import com.postech.entregavel1techchallenge.adapters.out.repository.mapper.CustomerEntityMapper;
import com.postech.entregavel1techchallenge.application.core.domain.Customer;
import com.postech.entregavel1techchallenge.application.ports.out.customer.GetCustomerByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindCustomerByIdAdapter implements GetCustomerByIdOutputPort {

    private final CustomerRepository customerRepository;

    private final CustomerEntityMapper entityMapper;

    @Override
    @Transactional(readOnly = true)
    public Optional<Customer> get(String id) {
        return customerRepository.findById(id)
                .map(entityMapper::toCustomer);
    }
}
