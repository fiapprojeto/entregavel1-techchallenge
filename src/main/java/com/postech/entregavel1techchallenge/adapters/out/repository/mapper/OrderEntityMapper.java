package com.postech.entregavel1techchallenge.adapters.out.repository.mapper;

import com.postech.entregavel1techchallenge.adapters.out.repository.entity.OrderEntity;
import com.postech.entregavel1techchallenge.adapters.out.repository.entity.OrderItemEntity;
import com.postech.entregavel1techchallenge.adapters.out.repository.entity.ProductEntity;
import com.postech.entregavel1techchallenge.application.core.domain.order.Order;
import com.postech.entregavel1techchallenge.application.core.domain.order.OrderItem;
import com.postech.entregavel1techchallenge.application.core.domain.product.Product;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = ProductEntityMapper.class)
public interface OrderEntityMapper {

    @InheritConfiguration
    @Mapping(source = "items", target = "items", qualifiedByName = "mapItems")
    OrderEntity toOrderEntity(Order order);

    @Named("mapItems")
    default List<OrderItemEntity> mapItems(List<OrderItem> orderItems) {
        return orderItems.stream()
                .map(this::mapOrderItem)
                .toList();
    }

    default OrderItemEntity mapOrderItem(OrderItem orderItem) {
        return OrderItemEntity.builder()
                .quantity(orderItem.getQuantity())
                .amount(orderItem.getAmount())
                .product(ProductEntity.builder().id(orderItem.getProduct().getId()).build())
                .build();
    }


    @Mapping(source = "items", target = "items", qualifiedByName = "mapItemsOrder")
    Order toOrder(OrderEntity orderEntity);
    @Named("mapItemsOrder")
    default List<OrderItem> mapItemsOrder(List<OrderItemEntity> orderItems) {
        return orderItems.stream()
                .map(this::mapOrderItem)
                .toList();
    }

    default OrderItem mapOrderItem(OrderItemEntity orderItemEntity) {
        return OrderItem.builder()
                .quantity(orderItemEntity.getQuantity())
                .amount(orderItemEntity.getAmount())
                .product(Product.builder().id(orderItemEntity.getProduct().getId()).build())
                .build();
    }

}

