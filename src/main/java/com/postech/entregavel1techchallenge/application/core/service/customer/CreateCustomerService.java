package com.postech.entregavel1techchallenge.application.core.service.customer;

import com.postech.entregavel1techchallenge.application.core.domain.Customer;
import com.postech.entregavel1techchallenge.application.core.exceptions.customer.AlreadyExistsCustomerException;
import com.postech.entregavel1techchallenge.application.ports.in.customer.CreateCustomerInputPort;
import com.postech.entregavel1techchallenge.application.ports.out.customer.ExistsCustomerByDocumentOutputPort;
import com.postech.entregavel1techchallenge.application.ports.out.customer.ExistsCustomerByEmailOutputPort;
import com.postech.entregavel1techchallenge.application.ports.out.customer.SaveCustomerOutPort;
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
