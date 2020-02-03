package com.insure.client.security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Scanner;


public class DecryptPriv {
    private Cipher cipher;
    private String key;
    private String encryptMsg;

    public DecryptPriv(String key, String encryptMsg) throws NoSuchAlgorithmException, NoSuchPaddingException {
        this.cipher = Cipher.getInstance("RSA");
        this.key = key;
        this.encryptMsg = encryptMsg;
    }


    // https://docs.oracle.com/javase/8/docs/api/java/security/spec/PKCS8EncodedKeySpec.html
    public PrivateKey getPrivate(String filename) throws Exception {
        byte[] keyBytes = Files.readAllBytes(new File(filename).toPath());
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }


    public String decryptText(String msg, Key key)
            throws InvalidKeyException, UnsupportedEncodingException,
            IllegalBlockSizeException, BadPaddingException {
        this.cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.getDecoder().decode(msg)), "UTF-8");
    }

    public String getEncryptedMsg() throws Exception {
        PrivateKey prvKey = this.getPrivate(Paths.get("").toAbsolutePath() +
                System.getProperty("file.separator") + "keys/Private" + System.getProperty("file.separator") + this.key + System.getProperty("file.separator") + this.key + "PrivateKey");
        return  this.decryptText(this.encryptMsg, prvKey);
    }

    public static String encryptMsg(String key, String message) throws Exception {
        return (new EncryptPriv(key, message)).getEncryptedMsg();
    }

}
