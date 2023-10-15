package com.postech.entregavel1techchallenge.adapters.out.repository.entity;

import com.postech.entregavel1techchallenge.adapters.out.repository.entity.ref.BaseAuditEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "tb_customer")
@Entity(name = "Customer")
public class CustomerEntity extends BaseAuditEntity {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    private String id;
    private String name;
    private String email;
    private String document;
}
