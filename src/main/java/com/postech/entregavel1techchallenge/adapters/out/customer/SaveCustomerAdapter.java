package com.postech.entregavel1techchallenge.adapters.out.customer;

import com.postech.entregavel1techchallenge.adapters.out.repository.CustomerRepository;
import com.postech.entregavel1techchallenge.adapters.out.repository.entity.CustomerEntity;
import com.postech.entregavel1techchallenge.application.core.domain.customer.Customer;
import com.postech.entregavel1techchallenge.application.ports.out.customer.SaveCustomerOutPort;
import com.postech.entregavel1techchallenge.config.mapper.ModelMapperCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class SaveCustomerAdapter implements SaveCustomerOutPort {

    private final CustomerRepository customerRepository;

    private final ModelMapperCustom mapper;

    @Override
    @Transactional
    public Customer save(Customer customer) {
        var customerEntity = mapper.map(customer, CustomerEntity.class);
        customerRepository.save(customerEntity);
        return mapper.map(customerEntity, Customer.class);
    }
}
