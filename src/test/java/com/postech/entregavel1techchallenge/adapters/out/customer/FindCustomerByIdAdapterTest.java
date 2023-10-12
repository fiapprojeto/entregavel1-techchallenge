package com.postech.entregavel1techchallenge.adapters.out.customer;

import com.postech.entregavel1techchallenge.adapters.out.customer.FindCustomerByIdAdapter;
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
@DisplayName("Adapter - FindCustomerByIdAdapter")
class FindCustomerByIdAdapterTest {

    @InjectMocks
    private FindCustomerByIdAdapter findCustomerByIdAdapter;

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

        when(customerRepository.findById(anyString()))
                .thenReturn(Optional.of(customerEntity));
    }

    @Test
    @DisplayName("get returns Customer when ID exists")
    void get_ReturnsCustomer_WhenIdExists() {
        var foundCustomer = findCustomerByIdAdapter.get("1");
        assertThat(foundCustomer).isPresent().contains(customer);
    }

    @Test
    @DisplayName("get returns empty when ID does not exist")
    void get_ReturnsEmpty_WhenIdNotExists() {
        when(customerRepository.findById(anyString()))
                .thenReturn(Optional.empty());

        var foundCustomer = findCustomerByIdAdapter.get("999");
        assertThat(foundCustomer).isEmpty();
    }

}