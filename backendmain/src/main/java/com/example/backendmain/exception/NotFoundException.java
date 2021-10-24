package com.example.backendmain.exception;

public class NotFoundException extends RuntimeException{
    private static final long serailVersionUID = 1L;

    public NotFoundException(String message){
        super(message);
    }
}

