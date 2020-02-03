package sise.cs.utils;

import javax.print.DocFlavor;
import java.security.MessageDigest;
import java.util.Base64;

public class Signature {
    String msg= "content";
    MessageDigest digest=MessageDigest.getInstance("SHA-256");
    String hash= Base64.getEncoder().encodeToString(digest.digest(msg.getBytes("UTF-8")));
}
