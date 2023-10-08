package com.postech.entregavel1techchallenge.adapters.in.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponse {
    private String id;
    private String name;
    private String email;
    private String document;
}
