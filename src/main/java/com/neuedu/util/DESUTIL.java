package com.neuedu.util;

import com.thoughtworks.xstream.core.util.Base64Encoder;

import javax.crypto.*;
import java.security.*;

/**
 * Created by mabaicong on 2019/4/6.
 */
public class DESUTIL {
    //加密
    static Key key;
    static String KEYSTR = "abc";
    static {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(KEYSTR.getBytes());
            keyGenerator.init(secureRandom);
            key = keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    public static String encode(String pwd) {
        String result = "";
        Base64Encoder base64Encoder = new Base64Encoder();
        try {
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE,key);
            byte[] b = cipher.doFinal(pwd.getBytes());
            result = base64Encoder.encode(b);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return result;
    }
    //解密
    public static String decode(String str) {
        String result = "";
        Base64Encoder base64Encoder = new Base64Encoder();
         byte[] b = base64Encoder.decode(str);
        try {
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE,key);
            byte[] pwd = cipher.doFinal(b);
            result = new String(pwd);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(encode("root"));
        System.out.println(encode("123456"));
    }
}
