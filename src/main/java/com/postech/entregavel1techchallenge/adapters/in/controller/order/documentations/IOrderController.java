package com.postech.entregavel1techchallenge.adapters.in.controller.order.documentations;

import com.postech.entregavel1techchallenge.adapters.in.controller.order.request.OrderRequest;
import com.postech.entregavel1techchallenge.adapters.in.controller.order.response.OrderResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Order", description = "Endpoints para gerenciar o pedido")
public interface IOrderController {

    @Operation(summary = "Criar pedido", description = "Endpoint responsável por realizar a criação de um pedido")
    @ApiResponses( value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Pedido criado com sucesso",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = OrderResponse.class))
                    }
            )
    })
    ResponseEntity<OrderResponse> create(@RequestBody @Valid OrderRequest request);
}
