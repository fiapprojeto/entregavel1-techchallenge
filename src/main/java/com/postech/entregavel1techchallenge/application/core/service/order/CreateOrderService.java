package com.postech.entregavel1techchallenge.application.core.service.order;


import com.postech.entregavel1techchallenge.application.core.domain.order.Order;
import com.postech.entregavel1techchallenge.application.core.exceptions.order.OrderCustomerNotFoundException;
import com.postech.entregavel1techchallenge.application.core.exceptions.order.OrderProductNotFoundException;
import com.postech.entregavel1techchallenge.application.ports.in.order.CreateOrderInputPort;
import com.postech.entregavel1techchallenge.application.ports.out.customer.GetCustomerByIdOutputPort;
import com.postech.entregavel1techchallenge.application.ports.out.order.CreateOrderOutputPort;
import com.postech.entregavel1techchallenge.application.ports.out.product.GetProductByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CreateOrderService implements CreateOrderInputPort {

    private final GetProductByIdOutputPort getProductByIdOutputPort;

    private final CreateOrderOutputPort createOrderOutputPort;

    private final GetCustomerByIdOutputPort getCustomerByIdOutputPort;

    @Override
    public Order create(Order order) {
        checkCustomer(order.getCustomerId());
        populateItems(order);
        order.setDefaults();
        order.calculateTotal();
        return createOrderOutputPort.create(order);
    }

    private void checkCustomer(String customerId) {
        if(Objects.nonNull(customerId))
            getCustomerByIdOutputPort.get(customerId)
                    .orElseThrow(() -> new OrderCustomerNotFoundException(
                            "Cliente informado não encontrado para seguir com pedido!"));
    }

    private void populateItems(Order order) {
        order.getItems().forEach(item -> {
            var product = getProductByIdOutputPort.get(item.getProduct().getId())
                    .orElseThrow(() -> new OrderProductNotFoundException(
                            "Um ou mais produto informado não encontrado para seguir com pedido!"));
            item.setProduct(product);
        });
    }
}
