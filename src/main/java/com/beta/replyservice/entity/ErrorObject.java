package com.beta.replyservice.entity;


public class ErrorObject {
    private  String message;

    public ErrorObject(String message) {
        this.message = message;
    }

    public ErrorObject() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
