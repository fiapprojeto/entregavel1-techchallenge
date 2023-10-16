package com.postech.entregavel1techchallenge.adapters.in.controller.order;

import com.postech.entregavel1techchallenge.adapters.in.controller.order.mapper.OrderRequestResponseMapper;
import com.postech.entregavel1techchallenge.adapters.in.controller.order.request.OrderRequest;
import com.postech.entregavel1techchallenge.adapters.in.controller.order.request.PayOrderRequest;
import com.postech.entregavel1techchallenge.adapters.in.controller.order.response.OrderResponse;
import com.postech.entregavel1techchallenge.application.ports.in.order.CancelOrderInputPort;
import com.postech.entregavel1techchallenge.application.ports.in.order.CreateOrderInputPort;
import com.postech.entregavel1techchallenge.application.ports.in.order.PayOrderInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final CreateOrderInputPort createOrderInputPort;

    private final CancelOrderInputPort cancelOrderInputPort;

    private final PayOrderInputPort payOrderInputPort;

    private final OrderRequestResponseMapper mapper;

    @PostMapping
    public ResponseEntity<OrderResponse> create(@RequestBody @Valid OrderRequest request) {
        log.info("Criacao de pedido recebido. [request: {}]", request);

        var order = createOrderInputPort.create(mapper.toOrder(request));
        var response = mapper.toOrderResponse(order);

        log.info("Pedido criado com sucesso. [response: {}]", response);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("{orderId}/cancel")
    public ResponseEntity<Void> cancel(@PathVariable String orderId) {
        log.info("Cancelando pedido com id: {}", orderId);
        cancelOrderInputPort.cancel(orderId);
        log.info("Pedido cancelado com sucesso. [orderId: {}]", orderId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("{orderId}/pay")
    public ResponseEntity<Void> pay(@PathVariable String orderId, @RequestBody PayOrderRequest orderRequest) {
        log.info("Inicio do pagament. [orderId: {}, request: {}]", orderId, orderRequest);
        payOrderInputPort.pay(orderId, orderRequest.total());
        log.info("Pagamento efetuado com sucesso. [orderId: {}]", orderId);
        return ResponseEntity.noContent().build();
    }

}
