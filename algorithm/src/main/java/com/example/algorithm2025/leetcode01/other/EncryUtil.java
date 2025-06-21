package com.example.algorithm2025.leetcode01.other;

import org.jasypt.util.text.BasicTextEncryptor;

public class EncryUtil {
    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword("passwd");
        String myEncryptedText = textEncryptor.encrypt("123456");
        System.out.println("加密后：" + myEncryptedText);
        String plainText = textEncryptor.decrypt(myEncryptedText);
        System.out.println("解密后：" +plainText);
    }
}
