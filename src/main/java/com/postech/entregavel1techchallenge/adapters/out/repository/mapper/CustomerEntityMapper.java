package com.postech.entregavel1techchallenge.adapters.out.repository.mapper;

import com.postech.entregavel1techchallenge.adapters.out.repository.entity.CustomerEntity;
import com.postech.entregavel1techchallenge.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);
}
