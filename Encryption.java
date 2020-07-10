package com.github.jnstockley.addressbook;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Base64;
 
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
 
/**
 * This class helps with AES encryption and decryption of sensitive data before being sent to the database
 * @author jackstockley
 * @version 3.0
 */
public class Encryption {
 
    private static SecretKeySpec secretKey;
    private static byte[] key; 
    
    /**
     * Makes a request to the database and retrieves the key
     * @return The key used to encrypt and decrypt
     */
    private static String getKey() {
    	try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://10.0.0.191/enc?user=Jack&password=Dr1v3r0o");
			PreparedStatement ps = conn.prepareStatement("SELECT privkey FROM enc");
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}else {
				return null;
			}
    	} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    /**
     * Converts the key and stores it as a variable
     * @param myKey The private key stored on the database
     */
    private static void setKey(String myKey) 
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); 
            secretKey = new SecretKeySpec(key, "AES");
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
 
    /**
     * Encrypts a string and returns it
     * @param strToEncrypt Plain text string to be encrypted
     * @return Encypted string
     */
    public static String encrypt(String strToEncrypt) 
    {
        try
        {
            setKey(getKey());
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } 
        catch (Exception e) 
        {
        	e.printStackTrace();
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
 
    /**
     * Decrypts a string and returns it
     * @param strToDecrypt encrypted string to be decrypted
     * @return Plain text string
     */
    public static String decrypt(String strToDecrypt) 
    {
        try
        {
            setKey(getKey());
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } 
        catch (Exception e) 
        {
        	e.printStackTrace();
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
}