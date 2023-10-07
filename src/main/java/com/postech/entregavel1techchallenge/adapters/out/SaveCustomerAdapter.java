package com.postech.entregavel1techchallenge.adapters.out;

import com.postech.entregavel1techchallenge.adapters.out.repository.CustomerRepository;
import com.postech.entregavel1techchallenge.adapters.out.repository.entity.CustomerEntity;
import com.postech.entregavel1techchallenge.adapters.out.repository.mapper.CustomerEntityMapper;
import com.postech.entregavel1techchallenge.application.core.domain.Customer;
import com.postech.entregavel1techchallenge.application.ports.out.SaveCustomerOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class SaveCustomerAdapter implements SaveCustomerOutPort {

    private final CustomerRepository customerRepository;

    private final CustomerEntityMapper entityMapper;

    @Override
    @Transactional
    public Customer save(Customer customer) {
        var customerEntity = entityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
        return entityMapper.toCustomer(customerEntity);
    }
}
