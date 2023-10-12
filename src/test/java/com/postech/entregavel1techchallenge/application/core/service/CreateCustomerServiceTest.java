package com.postech.entregavel1techchallenge.application.core.service;

import com.postech.entregavel1techchallenge.application.core.domain.Customer;
import com.postech.entregavel1techchallenge.application.core.exceptions.customer.AlreadyExistsCustomerException;
import com.postech.entregavel1techchallenge.application.core.service.customer.CreateCustomerService;
import com.postech.entregavel1techchallenge.application.ports.out.customer.ExistsCustomerByDocumentOutputPort;
import com.postech.entregavel1techchallenge.application.ports.out.customer.ExistsCustomerByEmailOutputPort;
import com.postech.entregavel1techchallenge.application.ports.out.customer.SaveCustomerOutPort;
import com.postech.entregavel1techchallenge.util.TestDataCreatorUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@DisplayName("Service - CreateCustomerService")
class CreateCustomerServiceTest {

    @InjectMocks
    private CreateCustomerService createCustomerService;
    @Mock
    private ExistsCustomerByDocumentOutputPort existsCustomerByDocumentOutputPort;
    @Mock
    private ExistsCustomerByEmailOutputPort existsCustomerByEmailOutputPort;
    @Mock
    private SaveCustomerOutPort saveCustomerOutPort;

    private Customer customer;

    @BeforeEach
    protected void beforeEach() {
        customer = TestDataCreatorUtil.newCustomer();

        when(existsCustomerByDocumentOutputPort.exists(anyString()))
                .thenReturn(Boolean.FALSE);

        when(existsCustomerByEmailOutputPort.exists(anyString()))
                .thenReturn(Boolean.FALSE);

        when(saveCustomerOutPort.save(any(Customer.class)))
                .thenReturn(customer);
    }

    @Test
    @DisplayName("save returns Customer when successful")
    void save_ReturnCustomer_WhenSuccessful() {
        var customerSaved = createCustomerService.save(customer);
        assertThat(customerSaved).isNotNull().isEqualTo(customer);
    }

    @Test
    @DisplayName("save throws AlreadyExistsCustomerException when document already exists")
    void save_ThrowsAlreadyExistsCustomerException_DocumentAlreadyExists() {
        when(existsCustomerByDocumentOutputPort.exists(anyString()))
                .thenReturn(Boolean.TRUE);

        assertThatThrownBy(() -> createCustomerService.save(customer))
                .isInstanceOf(AlreadyExistsCustomerException.class)
                .hasMessage("O documento informado já está em uso.");
    }

    @Test
    @DisplayName("save throws AlreadyExistsCustomerException when email already exists")
    void save_ThrowsAlreadyExistsCustomerException_EmailAlreadyExists() {
        when(existsCustomerByEmailOutputPort.exists(anyString()))
                .thenReturn(Boolean.TRUE);

        assertThatThrownBy(() -> createCustomerService.save(customer))
                .isInstanceOf(AlreadyExistsCustomerException.class)
                .hasMessage("O email informado já está em uso.");
    }
}