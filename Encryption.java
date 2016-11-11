/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Random;
import java.util.UUID;
public class Encryption
{
    //UUID.randomUUID().toString() generateds 36 bytes AES key
    //using subSequesnce making the string 16 bytes
    private final String randomKey = "11111kkkkk1111k1";//(String) UUID.randomUUID().toString().subSequence(0, 16);//128 bit key
    // Create key and cipher
    private final Key aesKey = new SecretKeySpec(randomKey.getBytes(),"md5");
    Cipher cipher;//Cipher.getInstance("AES");
    public byte[] encrypt(String text) 
    {
        try 
        {
            //String text = "Hello World";
            Random random = new Random();
            String randKey = UUID.randomUUID().toString();
            //UUID.randomUUID().toString() generateds 36 bytes AES key
            //using subSequesnce making the string 16 bytes
            //String key =  (String) UUID.randomUUID().toString().subSequence(0, 16);// 128 bit key
            System.out.println("key is: "+ randomKey);
            // Create key and cipher
            //Key aesKey = new SecretKeySpec(randomKey.getBytes(), "AES");
            cipher = Cipher.getInstance("AES");
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            String xyz = cipher.doFinal(text.getBytes()).toString();
            byte[] encrypted = cipher.doFinal(text.getBytes());
            System.err.println(encrypted.toString());
            System.err.println(new String(encrypted));
            return encrypted;
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        return null;
    }
    public String decryption(byte[] encrypted){
        
        try{
            //cipher = Cipher.getInstance("AES");
            //String key = "e8a7f643-2879-42";
            // decrypt the text
            
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(encrypted));
            System.err.println(decrypted);
            return decrypted;
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    
    return "";
    }
    public static void main(String[] args) 
    {
        Encryption app = new Encryption();
        Encryption bpp = new Encryption();
        byte[] abc = app.encrypt("janina1");
        byte[] bcd = app.encrypt("janina1");
        System.out.println(app.decryption(abc));
        System.out.println(app.decryption(bcd));

    }
}