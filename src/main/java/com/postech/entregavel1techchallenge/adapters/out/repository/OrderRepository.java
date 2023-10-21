package com.postech.entregavel1techchallenge.adapters.out.repository;

import com.postech.entregavel1techchallenge.adapters.out.repository.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, String> {

    List<OrderEntity> findByProgressAndStatus(String progress, String status);
}
