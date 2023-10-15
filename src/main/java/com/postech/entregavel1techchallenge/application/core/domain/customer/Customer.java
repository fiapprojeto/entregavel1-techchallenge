package com.postech.entregavel1techchallenge.application.core.domain.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private String id;
    private String name;
    private String email;
    private String document;
}
