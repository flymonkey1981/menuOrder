package com.menuorder.demo.util;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;

public class Security {

    public static String md5(String str) {
        String myHash = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] digest = md.digest();
            myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return myHash;
    }
}
