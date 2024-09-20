package com.example.algorithm.str;

public class ReverseString {
    public void reverseString(char[] s) {
        int i = 0;
        int r = s.length - 1;
        while (i < r) {
            char temp = s[i];
            s[i] = s[r];
            s[r] = temp;
            i++;
            r--;
        }
    }
}
