package com.insure.client.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Signature {
    public static String signMessage(String message, String key) throws NoSuchAlgorithmException {

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(message.getBytes());

        return new String(messageDigest.digest());
    }

}
