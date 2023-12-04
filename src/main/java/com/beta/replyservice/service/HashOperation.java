package com.beta.replyservice.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashOperation implements Operation{
    @Override
    public String perform(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(input.getBytes());
        BigInteger bigInt = new BigInteger(1,digest);


        return bigInt.toString(16) ;
    }
}
