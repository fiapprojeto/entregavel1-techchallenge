package com.postech.entregavel1techchallenge.adapters.in.controller.order;

import com.postech.entregavel1techchallenge.adapters.in.controller.order.documentations.IOrderController;
import com.postech.entregavel1techchallenge.adapters.in.controller.order.mapper.OrderRequestResponseMapper;
import com.postech.entregavel1techchallenge.adapters.in.controller.order.request.OrderRequest;
import com.postech.entregavel1techchallenge.adapters.in.controller.order.request.PayOrderRequest;
import com.postech.entregavel1techchallenge.adapters.in.controller.order.response.OrderResponse;
import com.postech.entregavel1techchallenge.application.core.domain.order.Order;
import com.postech.entregavel1techchallenge.application.core.domain.order.enums.OrderProgressEnum;
import com.postech.entregavel1techchallenge.application.ports.in.order.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController implements IOrderController {

    private final CreateOrderInputPort createOrderInputPort;

    private final CancelOrderInputPort cancelOrderInputPort;

    private final PayOrderInputPort payOrderInputPort;

    private final ChangeProgressOrderInputPort changeProgressOrderInputPort;

    private final FindOrdersByProgressInputPort findOrdersByProgressInputPort;

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

    @PatchMapping("{orderId}/change-progress")
    public ResponseEntity<Void> changeProgress(@PathVariable String orderId) {
        log.info("Alterando o andamento do pedido. [orderId: {}]", orderId);
        changeProgressOrderInputPort.change(orderId);
        log.info("Andamento do pedido alterado com sucesso. [orderId: {}]", orderId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> get(@RequestParam OrderProgressEnum progress) {
        log.info("Buscando pedidos com o andamento: {}", progress);
        var orders = findOrdersByProgressInputPort.get(progress).stream()
                .map(mapper::toOrderResponse)
                .toList();
        return ResponseEntity.ok(orders);
    }

}
