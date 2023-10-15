package com.postech.entregavel1techchallenge.adapters.out.repository.entity;

import com.postech.entregavel1techchallenge.adapters.out.repository.entity.ref.BaseAuditEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "tb_order")
@Entity(name = "Order")
public class OrderEntity extends BaseAuditEntity {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    private String id;

    private String status;

    private String progress;

    private BigDecimal total;

    private String customerId;

    @OneToMany(mappedBy = "order")
    private List<OrderItemEntity> items;
}
