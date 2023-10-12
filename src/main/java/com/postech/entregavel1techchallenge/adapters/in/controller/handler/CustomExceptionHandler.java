package com.postech.entregavel1techchallenge.adapters.in.controller.handler;

import com.postech.entregavel1techchallenge.application.core.exceptions.BaseException;
import com.postech.entregavel1techchallenge.application.core.exceptions.ExceptionDetails;
import com.postech.entregavel1techchallenge.application.core.exceptions.customer.AlreadyExistsCustomerException;
import com.postech.entregavel1techchallenge.application.core.exceptions.customer.CustomerNotFoundException;
import com.postech.entregavel1techchallenge.application.core.exceptions.product.ProductNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AlreadyExistsCustomerException.class)
    public ResponseEntity<ExceptionDetails> handlerAlreadyExistsCustomerException(AlreadyExistsCustomerException ex) {
        return buildException(ex, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerCustomerNotFoundException(CustomerNotFoundException ex) {
        return buildException(ex, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerProductNotFoundException(ProductNotFoundException ex) {
        return buildException(ex, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<ExceptionDetails> buildException(BaseException ex, HttpStatus httpStatus) {
        var exceptionDetails = ExceptionDetails.builder()
                .status(httpStatus.value())
                .title(ex.getTitle())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(exceptionDetails, httpStatus);
    }


    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex,
                                                             Object body,
                                                             HttpHeaders headers,
                                                             HttpStatusCode statusCode,
                                                             WebRequest request) {

        var exceptionDetails = ExceptionDetails.builder()
                .status(statusCode.value())
                .title(ex.getCause().getMessage())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(exceptionDetails, headers, statusCode);
    }
}
