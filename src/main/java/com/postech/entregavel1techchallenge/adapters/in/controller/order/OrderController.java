package com.postech.entregavel1techchallenge.adapters.in.controller.order;

import com.postech.entregavel1techchallenge.adapters.in.controller.order.mapper.OrderRequestResponseMapper;
import com.postech.entregavel1techchallenge.adapters.in.controller.order.request.OrderRequest;
import com.postech.entregavel1techchallenge.adapters.in.controller.order.response.OrderResponse;
import com.postech.entregavel1techchallenge.application.ports.in.order.CreateOrderInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final CreateOrderInputPort createOrderInputPort;

    private final OrderRequestResponseMapper mapper;


    @PostMapping
    public ResponseEntity<OrderResponse> create(@RequestBody @Valid OrderRequest request) {
        log.info("Criacao de pedido recebido. [request: {}]", request);

        var order = createOrderInputPort.create(mapper.toOrder(request));
        var response = mapper.toOrderResponse(order);

        log.info("Pedido criado com sucesso. [response: {}]", response);

        return ResponseEntity.ok(response);
    }

}
