package com.insure.client.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Signature {
    public static String signMessage(String key, String message) throws Exception {

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(message.getBytes());

        return EncryptPriv.encryptMsg(key, new String(messageDigest.digest()));
    }
}
