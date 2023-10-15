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
@Table(name = "tb_product")
@Entity(name = "Product")
public class ProductEntity extends BaseAuditEntity {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    private String id;
    private String name;
    private String description;
    private String images;
    private BigDecimal amount;
    private String category;
}
