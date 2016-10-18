package com.bpmw.services;

import javax.enterprise.context.RequestScoped;
import java.security.MessageDigest;

@RequestScoped
public class PasswordService {

    /**
     * The method generates a hash of the password (SHA256)
     * @param pass - password
     * @return - password hash (SHA-256)
     */
    public String passwordHash (String pass) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(pass.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
