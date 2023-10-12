package com.postech.entregavel1techchallenge.adapters.in.controller.customer.documentations;

import com.postech.entregavel1techchallenge.adapters.in.controller.customer.request.CustomerRequest;
import com.postech.entregavel1techchallenge.adapters.in.controller.customer.response.CustomerResponse;
import com.postech.entregavel1techchallenge.application.core.exceptions.ExceptionDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

@Tag(name = "Customer", description = "Endpoints para gerenciar o cliente")
public interface ICustomerController {

    @Operation(summary = "Criar cliente", description = "Endpoint responsável por realizar a criação de um cliente")
    @ApiResponses( value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Cliente cadastrado com sucesso",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerResponse.class))
                    }
            ),
            @ApiResponse(
                    responseCode = "422",
                    description = "Quando o email ou documento do cliente já está em uso",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDetails.class))
                    }
            )
    })
    ResponseEntity<CustomerResponse> create(@RequestBody @Valid CustomerRequest request,
                                                   UriComponentsBuilder uriBuilder);

    @Operation(summary = "Busca cliente", description = "Endpoint responsável por buscar cliente por id")
    @ApiResponses( value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Cliente encontrado com sucesso",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerResponse.class))
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Quando o cliente não foi encontrado pelo id",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDetails.class))
                    }
            )
    })
    ResponseEntity<CustomerResponse> findById(@PathVariable String customerId);

    @Operation(summary = "Busca cliente", description = "Endpoint responsável por buscar cliente por documento")
    @ApiResponses( value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Cliente encontrado com sucesso",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerResponse.class))
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Quando o cliente não foi encontrado pelo documento",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDetails.class))
                    }
            )
    })
    ResponseEntity<CustomerResponse> findByDocument(@PathVariable String document);
}
