package com.example.algorithm.str;

public class ReplaceNumber {
    public static String replaceSpace(String s) {
        int count = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                count++;
            }
        }

        char[] chars = new char[s.length() + count * 5];
        int newSize = chars.length;
        System.arraycopy(s.toCharArray(), 0, chars, 0, s.length());
        for (int i = newSize - 1, j = s.length() - 1; j < i; j--, i++) {
            if (!Character.isDigit(chars[j])) {
                chars[i] = chars[j];
            } else {
                chars[i] = 'r';
                chars[i - 1] = 'e';
                chars[i - 2] = 'b';
                chars[i - 3] = 'm';
                chars[i - 4] = 'u';
                chars[i - 5] = 'n';
                i -= 5;
            }
        }
        return new String(chars);
    }
}
