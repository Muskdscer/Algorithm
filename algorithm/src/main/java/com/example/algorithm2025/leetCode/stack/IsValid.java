package com.example.algorithm2025.leetCode.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class IsValid {
    public boolean isValid(String s) {
        Deque<Character> que = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '[') {
                que.push(']');
            } else if (chars[i] == '{') {
                que.push('}');
            } else if (chars[i] == '(') {
                que.push(')');
            } else if (que.isEmpty() || que.peek() != chars[i]) {
                return false;
            } else {
                que.pop();
            }
        }
        return que.isEmpty();
    }
}
