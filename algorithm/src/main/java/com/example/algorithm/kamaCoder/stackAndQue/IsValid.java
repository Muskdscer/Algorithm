package com.example.algorithm.kamaCoder.stackAndQue;

import java.lang.*;
import java.util.*;
import java.io.*;

public class IsValid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            boolean flag = isValidStr(s);
        }
    }

    private static boolean isValidStr(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(') {
                deque.push(')');
            } else if (ch == '{') {
                deque.push('}');
            } else if (ch == '[') {
                deque.push(']');
            } else if (deque.isEmpty() || deque.peek() != ch) {
                return false;
            } else {
                deque.poll();
            }
        }
        return deque.isEmpty();
    }
}
