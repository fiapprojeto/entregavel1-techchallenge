package com.postech.entregavel1techchallenge.adapters.out.repository;

import com.postech.entregavel1techchallenge.adapters.out.repository.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, String> {
}
