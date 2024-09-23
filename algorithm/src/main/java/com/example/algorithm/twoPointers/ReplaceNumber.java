package com.example.algorithm.twoPointers;

public class ReplaceNumber {
    public static String replaceNumber(String s) {
        int count = 0;//统计字数个数
        int sOldSize = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                count++;
            }
        }

        char[] newS = new char[s.length() + count * 5];
        int sNewSize = newS.length;
        System.arraycopy(s.toCharArray(), 0, newS, 0, sOldSize);
        //双指针
        for (int i = sNewSize -1 , j = sOldSize - 1; j < i ; i--, j--) {
            if (!Character.isDigit(newS[j])) {
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
