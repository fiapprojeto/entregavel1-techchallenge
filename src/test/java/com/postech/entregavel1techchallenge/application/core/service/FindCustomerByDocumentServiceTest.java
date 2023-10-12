package com.postech.entregavel1techchallenge.application.core.service;

import com.postech.entregavel1techchallenge.application.core.domain.Customer;
import com.postech.entregavel1techchallenge.application.core.exceptions.customer.CustomerNotFoundException;
import com.postech.entregavel1techchallenge.application.core.service.customer.FindCustomerByDocumentService;
import com.postech.entregavel1techchallenge.application.ports.out.customer.GetCustomerByDocumentOutputPort;
import com.postech.entregavel1techchallenge.util.TestDataCreatorUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@DisplayName("Service - FindCustomerByDocumentService")
class FindCustomerByDocumentServiceTest {

    @InjectMocks
    private FindCustomerByDocumentService findCustomerByDocumentService;

    @Mock
    private GetCustomerByDocumentOutputPort getCustomerByDocumentOutputPort;

    private Customer customer;

    @BeforeEach
    protected void beforeEach() {
        customer = TestDataCreatorUtil.newCustomer();

        when(getCustomerByDocumentOutputPort.get(anyString()))
                .thenReturn(Optional.of(customer));
    }

    @Test
    @DisplayName("find returns Customer when document exists")
    void find_ReturnsCustomer_WhenDocumentExists() {
        var foundCustomer = findCustomerByDocumentService.find("123456789");
        assertThat(foundCustomer).isNotNull().isEqualTo(customer);
    }

    @Test
    @DisplayName("find throws CustomerNotFoundException when document does not exist")
    void find_ThrowsCustomerNotFoundException_DocumentNotExists() {
        when(getCustomerByDocumentOutputPort.get(anyString()))
                .thenReturn(Optional.empty());

        assertThatThrownBy(() -> findCustomerByDocumentService.find("987654321"))
                .isInstanceOf(CustomerNotFoundException.class)
                .hasMessage("Cliente não encontrado para o documento informado.");
    }
}