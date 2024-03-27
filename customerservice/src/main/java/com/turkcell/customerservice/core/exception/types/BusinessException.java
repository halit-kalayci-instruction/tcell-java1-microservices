package com.turkcell.customerservice.core.exception.types;

public class BusinessException extends RuntimeException
{
    public BusinessException(String message) {
        super(message);
    }
}
