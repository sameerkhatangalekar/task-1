package com.beta.replyservice.service;

public class ReverseOperation implements Operation{
    @Override
    public String perform(String input) {
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }
}
