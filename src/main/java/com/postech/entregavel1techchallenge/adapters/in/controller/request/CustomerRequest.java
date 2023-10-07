package com.postech.entregavel1techchallenge.adapters.in.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class CustomerRequest {
    @NotNull
    private String name;
    @NotNull
    @Email
    private String email;
    @NotNull
    @CPF
    private String document;
}
