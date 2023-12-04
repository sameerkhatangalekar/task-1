package com.beta.replyservice.service;

import java.security.NoSuchAlgorithmException;

public interface Operation {
    String perform(String input) throws NoSuchAlgorithmException;
}
