package com.postech.entregavel1techchallenge.application.core.domain.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private String id;
    private String name;
    private String email;
    private String document;
}
