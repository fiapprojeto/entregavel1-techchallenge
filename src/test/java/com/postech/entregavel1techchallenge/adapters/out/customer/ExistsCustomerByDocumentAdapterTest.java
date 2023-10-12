package com.postech.entregavel1techchallenge.adapters.out.customer;

import com.postech.entregavel1techchallenge.adapters.out.customer.ExistsCustomerByDocumentAdapter;
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
@DisplayName("Adapter - ExistsCustomerByDocumentAdapter")
class ExistsCustomerByDocumentAdapterTest {

    @InjectMocks
    private ExistsCustomerByDocumentAdapter existsCustomerByDocumentAdapter;

    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    protected void beforeEach() {
        when(customerRepository.existsByDocument(anyString()))
                .thenReturn(true); // Simula a existência do documento
    }

    @Test
    @DisplayName("exists returns true when document exists")
    void exists_ReturnsTrue_WhenDocumentExists() {
        var documentExists = existsCustomerByDocumentAdapter.exists("123456789");
        assertThat(documentExists).isTrue();
    }

    @Test
    @DisplayName("exists returns false when document does not exist")
    void exists_ReturnsFalse_WhenDocumentNotExists() {
        when(customerRepository.existsByDocument(anyString()))
                .thenReturn(false);

        var documentExists = existsCustomerByDocumentAdapter.exists("987654321");
        assertThat(documentExists).isFalse();
    }

}