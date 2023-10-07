package com.postech.entregavel1techchallenge.adapters.out.repository;

import com.postech.entregavel1techchallenge.adapters.out.repository.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {

    Optional<CustomerEntity> findByDocument(String document);

    boolean existsByEmail(String email);

    boolean existsByDocument(String document);

}
