package com.beta.replyservice.exceptions;

public class InvalidInputException extends  RuntimeException{
    public InvalidInputException(){
        super("Invalid input");
    }
    public InvalidInputException(String message) {
        super(message);
    }
}
