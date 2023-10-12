package com.postech.entregavel1techchallenge.adapters.out.customer;

import com.postech.entregavel1techchallenge.adapters.out.customer.FindCustomerByDocumentAdapter;
import com.postech.entregavel1techchallenge.adapters.out.repository.CustomerRepository;
import com.postech.entregavel1techchallenge.adapters.out.repository.entity.CustomerEntity;
import com.postech.entregavel1techchallenge.adapters.out.repository.mapper.CustomerEntityMapper;
import com.postech.entregavel1techchallenge.application.core.domain.Customer;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@DisplayName("Adapter - FindCustomerByDocumentAdapter")
class FindCustomerByDocumentAdapterTest {

    @InjectMocks
    private FindCustomerByDocumentAdapter findCustomerByDocumentAdapter;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerEntityMapper entityMapper;

    private Customer customer;

    @BeforeEach
    protected void beforeEach() {
        customer = TestDataCreatorUtil.newCustomer();
        CustomerEntity customerEntity = TestDataCreatorUtil.newCustomerEntity();

        when(entityMapper.toCustomer(any(CustomerEntity.class)))
                .thenReturn(customer);

        when(customerRepository.findByDocument(anyString()))
                .thenReturn(Optional.of(customerEntity));
    }

    @Test
    @DisplayName("get returns Customer when document exists")
    void get_ReturnsCustomer_WhenDocumentExists() {
        var foundCustomer = findCustomerByDocumentAdapter.get("123456789");
        assertThat(foundCustomer).isPresent().contains(customer);
    }

    @Test
    @DisplayName("get returns empty when document does not exist")
    void get_ReturnsEmpty_WhenDocumentNotExists() {
        when(customerRepository.findByDocument(anyString()))
                .thenReturn(Optional.empty());

        var foundCustomer = findCustomerByDocumentAdapter.get("987654321");
        assertThat(foundCustomer).isEmpty();
    }
}