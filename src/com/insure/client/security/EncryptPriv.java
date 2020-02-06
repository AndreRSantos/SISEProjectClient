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

public class EncryptPriv {
    private Cipher cipher;
    private String message;
    private String key;

    public EncryptPriv(String key, String message) throws NoSuchAlgorithmException, NoSuchPaddingException {
        this.cipher = Cipher.getInstance("RSA");
        this.key = key;
        this.message = message;
    }

    public PrivateKey getPrivate(String filename) throws Exception {
        byte[] keyBytes = Files.readAllBytes(new File(filename).toPath());
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }


    public String encryptText(String msg, Key key)
            throws NoSuchAlgorithmException, NoSuchPaddingException,
            UnsupportedEncodingException, IllegalBlockSizeException,
            BadPaddingException, InvalidKeyException {
        this.cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.getEncoder().encodeToString(cipher.doFinal(msg.getBytes("UTF-8")));
    }

    public String getEncryptedMsg() throws Exception {
        PrivateKey prvKey = this.getPrivate(Paths.get("").toAbsolutePath() +
                System.getProperty("file.separator") + "keysC/Private" + System.getProperty("file.separator") + this.key + System.getProperty("file.separator") + this.key + "PrivateKey");
        return  this.encryptText(this.message, prvKey);
    }

    public static String encryptMsg(String key, String message) throws Exception {
        return (new EncryptPriv(key, message)).getEncryptedMsg();
    }

}
