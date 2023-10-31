package com.postech.entregavel1techchallenge.application.core.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionDetails {
    private String title;
    private int status;
    private String message;
    private String fields;
    private String fieldsMessage;
}
