package com.postech.entregavel1techchallenge.adapters.in.controller.product;

import com.postech.entregavel1techchallenge.adapters.in.controller.product.documentations.IProductController;
import com.postech.entregavel1techchallenge.adapters.in.controller.product.mapper.ProductRequestResponseMapper;
import com.postech.entregavel1techchallenge.adapters.in.controller.product.request.ProductRequest;
import com.postech.entregavel1techchallenge.adapters.in.controller.product.response.ProductResponse;
import com.postech.entregavel1techchallenge.application.ports.in.product.*;
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

    private final UpdateProductInputPort updateProductInputPort;

    private final DeleteProductInputPort deleteProductInputPort;

    private final ProductRequestResponseMapper mapper;

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody @Valid ProductRequest request,
                                                  UriComponentsBuilder uriBuilder) {
        log.info("Cadastro de novo produto recebido. [request: {}]", request);

        var product = createProductInputPort.save(mapper.toProduct(request));
        var response = mapper.toProductResponse(product);
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

    @PutMapping("{productId}")
    public ResponseEntity<ProductResponse> update(@RequestBody @Valid ProductRequest productRequest,
                                                  @PathVariable String productId) {
        log.info("Atualizacao de produto recebida. [id: {} e request: {}]", productId, productRequest);
        var product = updateProductInputPort.update(productId, mapper.toProduct(productRequest));
        var response = mapper.toProductResponse(product);

        log.info("Produto atualizado com sucesso. [response: {}]", response);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<Void> delete(@PathVariable String productId) {
        log.info("Requisicao para apagar produdo. [productId: {}]", productId);

        deleteProductInputPort.delete(productId);

        log.info("Produto apagado com sucesso. [productId: {}]", productId);

        return ResponseEntity.noContent().build();
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
