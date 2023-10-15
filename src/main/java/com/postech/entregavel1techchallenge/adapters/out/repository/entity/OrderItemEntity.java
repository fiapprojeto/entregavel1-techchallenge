package com.postech.entregavel1techchallenge.adapters.out.repository.entity;

import com.postech.entregavel1techchallenge.adapters.out.repository.entity.ref.BaseAuditEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "tb_order_item")
@Entity(name = "OrderItem")
public class OrderItemEntity extends BaseAuditEntity {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    private String id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    private BigDecimal amount;

    private Integer quantity;
}
