package com.postech.entregavel1techchallenge.application.core.service;

import com.postech.entregavel1techchallenge.application.core.domain.Customer;
import com.postech.entregavel1techchallenge.application.core.exceptions.customer.CustomerNotFoundException;
import com.postech.entregavel1techchallenge.application.core.service.customer.FindCustomerByIdService;
import com.postech.entregavel1techchallenge.application.ports.out.customer.GetCustomerByIdOutputPort;
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
@DisplayName("Service - FindCustomerByIdService")
class FindCustomerByIdServiceTest {

    @InjectMocks
    private FindCustomerByIdService findCustomerByIdService;

    @Mock
    private GetCustomerByIdOutputPort getCustomerByIdOutputPort;

    private Customer customer;

    @BeforeEach
    protected void beforeEach() {
        customer = TestDataCreatorUtil.newCustomer();

        when(getCustomerByIdOutputPort.get(anyString()))
                .thenReturn(Optional.of(customer));
    }

    @Test
    @DisplayName("find returns Customer when ID exists")
    void find_ReturnsCustomer_WhenIdExists() {
        var foundCustomer = findCustomerByIdService.find("1");
        assertThat(foundCustomer).isNotNull().isEqualTo(customer);
    }

    @Test
    @DisplayName("find throws CustomerNotFoundException when ID does not exist")
    void find_ThrowsCustomerNotFoundException_IdNotExists() {
        when(getCustomerByIdOutputPort.get(anyString()))
                .thenReturn(Optional.empty());

        assertThatThrownBy(() -> findCustomerByIdService.find("999"))
                .isInstanceOf(CustomerNotFoundException.class)
                .hasMessage("Cliente não encontrado para o id informado.");
    }
}