package com.postech.entregavel1techchallenge.adapters.out;

import com.postech.entregavel1techchallenge.adapters.out.repository.CustomerRepository;
import com.postech.entregavel1techchallenge.application.ports.out.ExistsCustomerByEmailOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ExistsCustomerByEmailAdapter implements ExistsCustomerByEmailOutputPort {

    private final CustomerRepository customerRepository;

    @Override
    @Transactional(readOnly = true)
    public boolean exists(String email) {
        return customerRepository.existsByEmail(email);
    }
}
