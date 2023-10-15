package com.postech.entregavel1techchallenge.application.core.domain.order;

import com.postech.entregavel1techchallenge.application.core.domain.order.enums.OrderProgressEnum;
import com.postech.entregavel1techchallenge.application.core.domain.order.enums.OrderStatusEnum;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class Order {

    private String id;

    private String customerId;

    private OrderStatusEnum status;

    private OrderProgressEnum progress;

    private List<OrderItem> items;

    private BigDecimal total;

    private LocalDateTime createDate;

    private LocalDateTime lastModifiedDate;

    public void setDefaults() {
        this.status = OrderStatusEnum.CREATED;
        this.progress = OrderProgressEnum.RECEBIDO;
    }

    public void calculateTotal() {
        this.total = items.stream()
                .map(OrderItem::calculate)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
