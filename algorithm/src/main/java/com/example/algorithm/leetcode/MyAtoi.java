package com.example.algorithm.leetcode;

public class MyAtoi {
    /**
     * 8. 字符串转换整数 (atoi) 自动机
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        Automaton automaton = new Automaton();
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(s.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }
}
