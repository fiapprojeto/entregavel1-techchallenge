package com.postech.entregavel1techchallenge.util;

import com.postech.entregavel1techchallenge.adapters.in.controller.customer.request.CustomerRequest;
import com.postech.entregavel1techchallenge.adapters.in.controller.customer.response.CustomerResponse;
import com.postech.entregavel1techchallenge.adapters.out.repository.entity.CustomerEntity;
import com.postech.entregavel1techchallenge.application.core.domain.customer.Customer;

import java.util.UUID;

public final class TestDataCreatorUtil {

    public static Customer newCustomer() {
        return Customer.builder()
                .id(UUID.randomUUID().toString())
                .email("testes@teste.com")
                .document("15260083431")
                .name("Cliente Teste")
                .build();
    }

    public static CustomerRequest newCustomerRequest() {
        return CustomerRequest.builder()
                .email("testes@teste.com")
                .document("15260083431")
                .name("Cliente Teste")
                .build();
    }

    public static CustomerResponse newCustomerResponse() {
        return CustomerResponse.builder()
                .id(UUID.randomUUID().toString())
                .email("testes@teste.com")
                .document("15260083431")
                .name("Cliente Teste")
                .build();
    }

    public static CustomerEntity newCustomerEntity() {
        return CustomerEntity.builder()
                .id(UUID.randomUUID().toString())
                .email("testes@teste.com")
                .document("15260083431")
                .name("Cliente Teste")
                .build();
    }
}
