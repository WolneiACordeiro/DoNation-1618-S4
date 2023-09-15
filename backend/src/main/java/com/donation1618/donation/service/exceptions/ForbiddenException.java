package com.donation1618.donation.service.exceptions;

public class ForbiddenException extends RuntimeException {
    public ForbiddenException(String msg){
        super(msg);
    }
}
