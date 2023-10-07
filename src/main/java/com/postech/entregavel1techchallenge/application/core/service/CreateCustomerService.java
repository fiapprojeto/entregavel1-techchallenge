package com.postech.entregavel1techchallenge.application.core.service;

import com.postech.entregavel1techchallenge.adapters.out.ExistsCustomerByEmailAdapter;
import com.postech.entregavel1techchallenge.adapters.out.SaveCustomerAdapter;
import com.postech.entregavel1techchallenge.application.core.domain.Customer;
import com.postech.entregavel1techchallenge.application.core.exceptions.AlreadyExistsCustomerException;
import com.postech.entregavel1techchallenge.application.ports.in.CreateCustomerInputPort;
import com.postech.entregavel1techchallenge.application.ports.out.ExistsCustomerByDocumentOutputPort;
import com.postech.entregavel1techchallenge.application.ports.out.ExistsCustomerByEmailOutputPort;
import com.postech.entregavel1techchallenge.application.ports.out.SaveCustomerOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCustomerService implements CreateCustomerInputPort {

    private final ExistsCustomerByDocumentOutputPort existsCustomerByDocumentOutputPort;

    private final ExistsCustomerByEmailOutputPort existsCustomerByEmailOutputPort;

    private final SaveCustomerOutPort saveCustomerOutPort;


    @Override
    public Customer save(Customer customer) {
        if(existsCustomerByDocumentOutputPort.exists(customer.getDocument()))
            throw new AlreadyExistsCustomerException("O documento informado já está em uso.");
        if(existsCustomerByEmailOutputPort.exists(customer.getEmail()))
            throw new AlreadyExistsCustomerException("O email informado já está em uso.");

        return saveCustomerOutPort.save(customer);
    }
}
