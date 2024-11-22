package com.example.algorithm.kamaCoder.str;

public class ReverseString {
    public static void main(String[] args) {
        String[] stringArray = new String[]{"h","e","l","l","o"};

        int left = 0;
        int right = stringArray.length - 1;
        while (left < right) {
            String temp = stringArray[left];
            stringArray[left] = stringArray[right];
            stringArray[right] = temp;
            left++;
            right--;
        }
    }
}
