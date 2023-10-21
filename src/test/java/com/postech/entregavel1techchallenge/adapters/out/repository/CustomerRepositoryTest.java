package com.postech.entregavel1techchallenge.adapters.out.repository;

import com.postech.entregavel1techchallenge.adapters.out.repository.entity.CustomerEntity;
import com.postech.entregavel1techchallenge.config.audit.AuditorAwareImpl;
import com.postech.entregavel1techchallenge.config.persistence.PersistenceConfig;
import com.postech.entregavel1techchallenge.util.TestDataCreatorUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

//@DataJpaTest(includeFilters = @ComponentScan.Filter(
//        type = ASSIGNABLE_TYPE,
//        classes = {AuditorAwareImpl.class, PersistenceConfig.class}
//))
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@TestPropertySource(locations = "classpath:application-test.yml")
//@ActiveProfiles("test")
//@DisplayName("Repository - CustomerRepository")
class CustomerRepositoryTest {

//    @Autowired
//    private CustomerRepository customerRepository;
//
//    private CustomerEntity customerEntity;
//
//    @BeforeEach
//    void clearDatabase() {
//        customerRepository.deleteAll();
//        customerEntity = TestDataCreatorUtil.newCustomerEntity();
//        //customerRepository.save(customerEntity);
//    }
//
//    @Test
//    @DisplayName("Save persists anime when Successful")
//    void save_PersistAnime_WhenSuccessful() {
//        customerEntity.setDocument("987654332133");
//        customerEntity.setEmail("tests@test");
//        var customerSaved = this.customerRepository.save(customerEntity);
//
//        assertThat(customerSaved).isNotNull();
//
//        assertThat(customerSaved.getId()).isNotNull();
//
//        assertThat(customerSaved.getName()).isEqualTo(customerSaved.getName());
//    }
//
//    @Test
//    @DisplayName("Find customer by document returns optional of customer when document exists")
//    void findByDocument_ReturnsOptionalOfCustomer_WhenDocumentExists() {
//        customerEntity.setDocument("987655332133");
//        customerEntity.setEmail("test2s1@test");
//        var customerSaved = this.customerRepository.save(customerEntity);
//
//        var foundCustomer = customerRepository.findByDocument(customerEntity.getDocument());
//
//        assertThat(foundCustomer).isPresent();
//        assertThat(foundCustomer.get().getDocument()).isEqualTo(customerEntity.getDocument());
//    }
//
//    @Test
//    @DisplayName("Find customer by document returns empty optional when document does not exist")
//    void findByDocument_ReturnsEmptyOptional_WhenDocumentNotExists() {
//        var foundCustomer = customerRepository.findByDocument("nonexistent_document");
//
//        assertThat(foundCustomer).isEmpty();
//    }
//
//    @Test
//    @DisplayName("Check if customer exists by email returns true when email exists")
//    void existsByEmail_ReturnsTrue_WhenEmailExists() {
//        customerEntity.setDocument("187654332133");
//        customerEntity.setEmail("tests3@test");
//        var customerSaved = this.customerRepository.save(customerEntity);
//
//        var emailExists = customerRepository.existsByEmail(customerEntity.getEmail());
//
//        assertThat(emailExists).isTrue();
//    }
//
//    @Test
//    @DisplayName("Check if customer exists by email returns false when email does not exist")
//    void existsByEmail_ReturnsFalse_WhenEmailNotExists() {
//        var emailExists = customerRepository.existsByEmail("nonexistent@example.com");
//
//        assertThat(emailExists).isFalse();
//    }
//
//    @Test
//    @DisplayName("Check if customer exists by document returns true when document exists")
//    void existsByDocument_ReturnsTrue_WhenDocumentExists() {
//        customerEntity.setDocument("9878854332133");
//        customerEntity.setEmail("testes5@test");
//        var customerSaved = this.customerRepository.save(customerEntity);
//
//        var documentExists = customerRepository.existsByDocument(customerSaved.getDocument());
//
//        assertThat(documentExists).isTrue();
//    }
//
//    @Test
//    @DisplayName("Check if customer exists by document returns false when document does not exist")
//    void existsByDocument_ReturnsFalse_WhenDocumentNotExists() {
//        var documentExists = customerRepository.existsByDocument("nonexistent_document");
//
//        assertThat(documentExists).isFalse();
//    }
}