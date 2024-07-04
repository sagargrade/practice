package edu.practice.svc.api.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message){
        super(message);
    }

    public NotFoundException(String message, Exception ex){
        super(message, ex);
    }

}
