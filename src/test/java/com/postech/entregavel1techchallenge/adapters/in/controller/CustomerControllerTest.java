package com.postech.entregavel1techchallenge.adapters.in.controller;

import com.postech.entregavel1techchallenge.adapters.in.controller.customer.CustomerController;
import com.postech.entregavel1techchallenge.adapters.in.controller.customer.mapper.CustomerRequestResponseMapper;
import com.postech.entregavel1techchallenge.adapters.in.controller.customer.request.CustomerRequest;
import com.postech.entregavel1techchallenge.adapters.in.controller.customer.response.CustomerResponse;
import com.postech.entregavel1techchallenge.application.core.domain.customer.Customer;
import com.postech.entregavel1techchallenge.application.ports.in.customer.CreateCustomerInputPort;
import com.postech.entregavel1techchallenge.application.ports.in.customer.FindCustomerByDocumentInputPort;
import com.postech.entregavel1techchallenge.application.ports.in.customer.FindCustomerByIdInputPort;
import com.postech.entregavel1techchallenge.util.TestDataCreatorUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Controller - CustomerController")
class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CreateCustomerInputPort createCustomerInputPortMock;

    @Mock
    private FindCustomerByDocumentInputPort findCustomerByDocumentInputPortMock;

    @Mock
    private FindCustomerByIdInputPort findCustomerByIdInputPortMock;

    @Mock
    private CustomerRequestResponseMapper mapperMock;

    private CustomerResponse customerResponse;

    private CustomerRequest customerRequest;

    private Customer customer;

    @BeforeEach
    protected void beforeEach() {
        customer = TestDataCreatorUtil.newCustomer();
        customerRequest = TestDataCreatorUtil.newCustomerRequest();
        customerResponse = TestDataCreatorUtil.newCustomerResponse();

        when(mapperMock.toCustomerResponse(any())).thenReturn(customerResponse);
    }

    @Test
    @DisplayName("create returns CustomerResponse when successful")
    void create_ReturnCustomerResponse_WhenSuccessOnCreateCustomerEndpoint() {
        when(mapperMock.toCustomer(customerRequest)).thenReturn(customer);
        when(createCustomerInputPortMock.save(customer)).thenReturn(customer);

        var response = customerController.create(customerRequest, UriComponentsBuilder.newInstance());

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(Objects.requireNonNull(response.getBody()).getId()).isNotNull().isEqualTo(customerResponse.getId());
    }

    @Test
    @DisplayName("findById returns CustomerResponse when successful")
    void findById_ReturnCustomerResponse_WhenSuccessOnFindByIdCustomerEndpoint() {
        when(findCustomerByIdInputPortMock.find(anyString())).thenReturn(customer);

        var response = customerController.findById(customerResponse.getId());

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(Objects.requireNonNull(response.getBody()).getId()).isNotNull().isEqualTo(customerResponse.getId());
    }

    @Test
    @DisplayName("findByDocument returns CustomerResponse when successful")
    void findByDocument_ReturnCustomerResponse_WhenSuccessOnFindByIdCustomerEndpoint() {
        when(findCustomerByDocumentInputPortMock.find(anyString())).thenReturn(customer);

        var response = customerController.findByDocument(customerResponse.getId());

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(Objects.requireNonNull(response.getBody()).getId()).isNotNull().isEqualTo(customerResponse.getId());
    }
}