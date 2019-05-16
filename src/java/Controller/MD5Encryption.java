/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author almand
 */
public class MD5Encryption {
    
    public StringBuilder encryption(String encrypt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(encrypt.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 2
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < byteData.length; i++) {
            String hex = Integer.toHexString(0xff & byteData[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString;
    }
}
