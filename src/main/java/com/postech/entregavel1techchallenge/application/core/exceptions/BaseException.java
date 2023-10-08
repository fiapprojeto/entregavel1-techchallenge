package com.postech.entregavel1techchallenge.application.core.exceptions;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException{

    private String title;

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, String title) {
        super(message);
        this.title = title;
    }
}
