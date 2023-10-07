package com.postech.entregavel1techchallenge.adapters.in.controller.mapper;

import com.postech.entregavel1techchallenge.adapters.in.controller.request.CustomerRequest;
import com.postech.entregavel1techchallenge.adapters.in.controller.response.CustomerResponse;
import com.postech.entregavel1techchallenge.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerRequestResponseMapper {
    Customer toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);
}
