package com.postech.entregavel1techchallenge.adapters.out.customer;

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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@DisplayName("Adapter - SaveCustomerAdapter")
class SaveCustomerAdapterTest {

    @InjectMocks
    private SaveCustomerAdapter saveCustomerAdapter;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerEntityMapper entityMapper;

    private Customer customer;

    @BeforeEach
    protected void beforeEach() {
        customer = TestDataCreatorUtil.newCustomer();
        CustomerEntity customerEntity = TestDataCreatorUtil.newCustomerEntity();

        when(entityMapper.toCustomerEntity(any(Customer.class)))
                .thenReturn(customerEntity);

        when(entityMapper.toCustomer(any(CustomerEntity.class)))
                .thenReturn(customer);

        when(customerRepository.save(any(CustomerEntity.class)))
                .thenReturn(customerEntity);
    }

    @Test
    @DisplayName("save returns Customer when successful")
    void save_ReturnsCustomer_WhenSuccessful() {
        var savedCustomer = saveCustomerAdapter.save(customer);
        assertThat(savedCustomer).isNotNull().isEqualTo(customer);
    }

}