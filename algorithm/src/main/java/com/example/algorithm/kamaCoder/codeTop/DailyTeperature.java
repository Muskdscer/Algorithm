package com.example.algorithm.kamaCoder.codeTop;

import java.util.Stack;


public class DailyTeperature {
    public static void main(String[] args) {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<Integer>();

        getResult(temperatures, stack, res);
        for (int i : res) {
            System.out.println(i);
        }
    }

    private static int[] getResult(int[] temperatures, Stack<Integer> stack, int[] res) {
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            if (temperature <= temperatures[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }
}
