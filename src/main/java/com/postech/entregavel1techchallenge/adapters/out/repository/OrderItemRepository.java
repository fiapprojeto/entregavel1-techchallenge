package com.postech.entregavel1techchallenge.adapters.out.repository;

import com.postech.entregavel1techchallenge.adapters.out.repository.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, String> {
}
