package com.bank.springAngular.exception;

import java.io.Serial;

public class ExceptionError extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;
    public ExceptionError(String message){
    }

}
