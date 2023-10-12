package com.postech.entregavel1techchallenge.adapters.in.controller.product.documentations;

import com.postech.entregavel1techchallenge.adapters.in.controller.customer.response.CustomerResponse;
import com.postech.entregavel1techchallenge.adapters.in.controller.product.request.ProductRequest;
import com.postech.entregavel1techchallenge.adapters.in.controller.product.response.ProductResponse;
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

import java.util.List;

@Tag(name = "Product", description = "Endpoints para gerenciar o produto")
public interface IProductController {

    @Operation(summary = "Criar produto", description = "Endpoint responsável por realizar a criação de um produto")
    @ApiResponses( value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Produto cadastrado com sucesso",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ProductResponse.class))
                    }
            )
    })
    ResponseEntity<ProductResponse> create(@RequestBody @Valid ProductRequest request,
                                           UriComponentsBuilder uriBuilder);

    @Operation(summary = "Busca produto", description = "Endpoint responsável por buscar produto por id")
    @ApiResponses( value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Produto encontrado com sucesso",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ProductResponse.class))
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Quando o produto não foi encontrado pelo id",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDetails.class))
                    }
            )
    })
    ResponseEntity<ProductResponse> getById(@PathVariable String productId);

    @Operation(summary = "Busca produtos", description = "Endpoint responsável por buscar produtos por categoria")
    @ApiResponses( value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Produtos encontrado com sucesso",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ProductResponse.class))
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Quando a pesquisa não encontrar produtos pela categoria",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDetails.class))
                    }
            )
    })
    ResponseEntity<List<ProductResponse>> getByCategory(@PathVariable String category);
}
