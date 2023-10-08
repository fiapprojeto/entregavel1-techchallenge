package com.postech.entregavel1techchallenge.adapters.in.controller;

import com.postech.entregavel1techchallenge.adapters.in.controller.documentations.ICustomerController;
import com.postech.entregavel1techchallenge.adapters.in.controller.mapper.CustomerRequestResponseMapper;
import com.postech.entregavel1techchallenge.adapters.in.controller.request.CustomerRequest;
import com.postech.entregavel1techchallenge.adapters.in.controller.response.CustomerResponse;
import com.postech.entregavel1techchallenge.application.ports.in.CreateCustomerInputPort;
import com.postech.entregavel1techchallenge.application.ports.in.FindCustomerByDocumentInputPort;
import com.postech.entregavel1techchallenge.application.ports.in.FindCustomerByIdInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController implements ICustomerController {

    private final CreateCustomerInputPort createCustomerInputPort;

    private final FindCustomerByDocumentInputPort findCustomerByDocumentInputPort;

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final CustomerRequestResponseMapper mapper;

    @PostMapping
    public ResponseEntity<CustomerResponse> create(@RequestBody @Valid CustomerRequest request,
                                                   UriComponentsBuilder uriBuilder) {
        log.info("Cadastro de novo cliente recebido. [request: {}]", request);

        var customer = createCustomerInputPort.save(mapper.toCustomer(request));
        var response = mapper.toCustomerResponse(customer);
        var uri = uriBuilder.path("/customers/{id}").buildAndExpand(response.getId()).toUri();

        log.info("Cliente cadastrado com sucesso. [response: {}]", response);
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("{customerId}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable String customerId) {
        log.info("Buscando cliente por id: {}", customerId);
        var customer = findCustomerByIdInputPort.find(customerId);
        var response = mapper.toCustomerResponse(customer);
        log.info("Cliente encontrado. [id: {} e response: {}", customerId, response);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{document}/document")
    public ResponseEntity<CustomerResponse> findByDocument(@PathVariable String document) {
        log.info("Buscando cliente por documento: {}", document);
        var customer = findCustomerByDocumentInputPort.find(document);
        var response = mapper.toCustomerResponse(customer);
        log.info("Cliente encontrado. [document: {} e response: {}", document, response);
        return ResponseEntity.ok(response);
    }


}
