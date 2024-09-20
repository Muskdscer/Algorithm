package com.example.algorithm.stackAndQueue;

import java.util.ArrayDeque;

public class RemoveDuplicates {
    public String removeDuplicates(String S) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        char ch;

        for (int i = 0; i < S.length(); i++) {
            ch = S.charAt(i);
            if (deque.isEmpty() || deque.peek() != ch) {
                deque.push(ch);
            } else {
                deque.pop();
            }
        }
        String str = "";
        //剩余的元素即为不重复的元素
        while (!deque.isEmpty()) {
            str = deque.pop() + str;
        }
        return str;
    }

}
