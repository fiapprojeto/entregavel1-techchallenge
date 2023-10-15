package com.postech.entregavel1techchallenge.application.core.service.customer;

import com.postech.entregavel1techchallenge.application.core.domain.customer.Customer;
import com.postech.entregavel1techchallenge.application.core.exceptions.customer.CustomerNotFoundException;
import com.postech.entregavel1techchallenge.application.ports.in.customer.FindCustomerByIdInputPort;
import com.postech.entregavel1techchallenge.application.ports.out.customer.GetCustomerByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindCustomerByIdService implements FindCustomerByIdInputPort {

    private final GetCustomerByIdOutputPort getCustomerByIdOutputPort;

    @Override
    public Customer find(String id) {
        return getCustomerByIdOutputPort.get(id)
                .orElseThrow(() -> new CustomerNotFoundException("Cliente não encontrado para o id informado."));
    }
}
