package com.example.algorithm.kamaCoder.str;

import java.util.*;
import java.io.*;

public class ReverseStringII {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        String newString = reverseString(s, 2);
    }

    private static String reverseString(String s, int k) {
        char[] ch = s.toCharArray();
        for(int i = 0;i < ch.length;i += 2 * k){
            int start = i;
            // 判断尾数够不够k个来取决end指针的位置
            int end = Math.min(ch.length - 1,start + k - 1);
            while(start < end){

                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;

                start++;
                end--;
            }
        }
        return new String(ch);


//        if (s.length() == 0) {
//            return "";
//        }
//
//        char[] chars = s.toCharArray();
//        StringBuilder sb = new StringBuilder();
//        if (chars.length < k) {
//            int left = 0;
//            int right = chars.length - 1;
//            reverseHepler(chars, left, right);
//        } else if (chars.length >= k && chars.length < 2*k) {
//            int left = 0;
//            int right = k;
//            reverseHepler(chars, left, right);
//        } else if (chars.length > 2*k) {
//            for (int i = 0; i < chars.length - 1; i+= 2*k) {
//                int left = i;
//                int right = i + k;
//                if ((i + 2*k) > chars.length - 1 && (i + k) > chars.length - 1 && i < chars.length - 1) {
//                    reverseHepler(chars, left, chars.length - 1);
//                } else if ((i + 2*k) > chars.length - 1 && (i + k) > chars.length - 1 && i < chars.length - 1) {
//
//                }
//
//            }
//        }
//        for (int i = 0; i < chars.length; i++) {
//            sb.append(chars[i]);
//        }
//        return sb.toString();
    }

    private static void reverseHepler(char[] chars, int left, int right) {

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
