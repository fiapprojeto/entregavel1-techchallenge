package com.postech.entregavel1techchallenge.adapters.in.controller.product;

import com.postech.entregavel1techchallenge.adapters.in.controller.product.documentations.IProductController;
import com.postech.entregavel1techchallenge.adapters.in.controller.product.mapper.ProductRequestResponseMapper;
import com.postech.entregavel1techchallenge.adapters.in.controller.product.request.ProductRequest;
import com.postech.entregavel1techchallenge.adapters.in.controller.product.response.ProductResponse;
import com.postech.entregavel1techchallenge.application.ports.in.product.CreateProductInputPort;
import com.postech.entregavel1techchallenge.application.ports.in.product.FindProductByIdInputPort;
import com.postech.entregavel1techchallenge.application.ports.in.product.GetProductsByCategoryInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController implements IProductController {

    private final CreateProductInputPort createProductInputPort;

    private final GetProductsByCategoryInputPort getProductsByCategoryInputPort;

    private final FindProductByIdInputPort findProductByIdInputPort;

    private final ProductRequestResponseMapper mapper;

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody @Valid ProductRequest request,
                                                  UriComponentsBuilder uriBuilder) {
        log.info("Cadastro de novo produto recebido. [request: {}]", request);

        var customer = createProductInputPort.save(mapper.toProduct(request));
        var response = mapper.toProductResponse(customer);
        var uri = uriBuilder.path("/products/{id}").buildAndExpand(response.getId()).toUri();

        log.info("Produto cadastrado com sucesso. [response: {}]", response);
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("{productId}")
    public ResponseEntity<ProductResponse> getById(@PathVariable String productId) {
        log.info("Buscando produto por id: {}", productId);
        var product = findProductByIdInputPort.get(productId);
        var response = mapper.toProductResponse(product);
        log.info("Produto encontrado. [id: {} response: {}]", productId, response);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{category}/category")
    public ResponseEntity<List<ProductResponse>> getByCategory(@PathVariable String category) {
        log.info("Buscando produtos para categoria: {}", category);
        var response = getProductsByCategoryInputPort.get(category).stream()
                .map(mapper::toProductResponse)
                .toList();

        return ResponseEntity.ok(response);
    }
}
