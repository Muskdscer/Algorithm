package com.example.algorithm.kamaCoder.hash;

import java.lang.*;
import java.util.*;
import java.io.*;

public class IsAnagram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] s = sc.nextLine().split(" ");
            String sA = s[0];
            String sB = s[1];
            boolean falg =  isAnagram(sA, sB);
        }
    }

    private static boolean isAnagram(String sA, String sB) {
        int[] record = new int[26];
        for (int i = 0; i < sA.length(); i++) {
            record[sA.charAt(i) - 'a']++;
        }
        for (int i = 0; i < sB.length(); i++) {
            record[sA.charAt(i) - 'a']--;
        }
        for (int i = 0; i < record.length; i++) {
            if (record[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
