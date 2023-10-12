package com.postech.entregavel1techchallenge.adapters.out.customer;

import com.postech.entregavel1techchallenge.adapters.out.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@DisplayName("Adapter - ExistsCustomerByEmailAdapter")
class ExistsCustomerByEmailAdapterTest {

    @InjectMocks
    private ExistsCustomerByEmailAdapter existsCustomerByEmailAdapter;

    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    protected void beforeEach() {
        when(customerRepository.existsByEmail(anyString()))
                .thenReturn(true); // Simula a existência do e-mail
    }

    @Test
    @DisplayName("exists returns true when email exists")
    void exists_ReturnsTrue_WhenEmailExists() {
        var emailExists = existsCustomerByEmailAdapter.exists("test@example.com");
        assertThat(emailExists).isTrue();
    }

    @Test
    @DisplayName("exists returns false when email does not exist")
    void exists_ReturnsFalse_WhenEmailNotExists() {
        when(customerRepository.existsByEmail(anyString()))
                .thenReturn(false);

        var emailExists = existsCustomerByEmailAdapter.exists("nonexistent@example.com");
        assertThat(emailExists).isFalse();
    }
}