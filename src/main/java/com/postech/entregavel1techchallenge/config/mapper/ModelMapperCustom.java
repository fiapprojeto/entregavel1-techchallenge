package com.postech.entregavel1techchallenge.config.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;

@AllArgsConstructor
public class ModelMapperCustom {

    private final ModelMapper mapper;

    public <T> T map(Object source, Class<T> destinationType) {
        if (source == null) {
            return null;
        }
        return this.mapper.map(source, destinationType);
    }

    public <T> List<T> map(List<?> list, Class<T> destinationType) {
        return list.stream().map(e -> map(e, destinationType)).toList();
    }

    public <T> T map(Object source, T destination) {
        this.mapper.map(source, destination);
        return destination;
    }

}
