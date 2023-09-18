package com.donation1618.donation.service.exceptions;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String msg){
        super(msg);
    }
}
