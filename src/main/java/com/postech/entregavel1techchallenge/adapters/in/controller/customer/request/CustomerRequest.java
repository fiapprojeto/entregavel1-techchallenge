package com.postech.entregavel1techchallenge.adapters.in.controller.customer.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
