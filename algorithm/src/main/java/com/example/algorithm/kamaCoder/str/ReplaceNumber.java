package com.example.algorithm.kamaCoder.str;

import java.util.*;
import java.io.*;

public class ReplaceNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        System.out.println(replaceNumber(next));
        sc.close();
    }

    private static String replaceNumber(String s) {
        int count = 0;
        int oldSize = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (Character.isDigit(chars[i])) {
                count++;
            }
        }

        char[] newS = new char[oldSize + count * 5];
        System.arraycopy(chars, 0, newS, 0, oldSize);

        for (int i = newS.length - 1, j = oldSize - 1; j < i ; i--, j--) {
            if (!Character.isDigit(newS[i])) {
                newS[i] = newS[j];
            } else {
                newS[i] = 'r';
                newS[i - 1] = 'e';
                newS[i - 2] = 'b';
                newS[i - 3] = 'm';
                newS[i - 4] = 'u';
                newS[i - 5] = 'n';
                i -= 5;
            }
        }
        return new String(newS);
    }
}
