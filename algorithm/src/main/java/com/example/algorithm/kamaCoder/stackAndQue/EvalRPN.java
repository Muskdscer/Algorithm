package com.example.algorithm.kamaCoder.stackAndQue;

import java.lang.*;
import java.util.*;
import java.io.*;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList();
        for (String token : tokens) {
            if ("+".equals(token)) {
                stack.push(stack.poll() + stack.poll());
            } else if ("-".equals(token)) {
                stack.push(-stack.poll() + stack.poll());
            } else if ("*".equals(token)) {
                stack.push(stack.poll() * stack.poll());
            } else if ("/".equals(token)) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.poll();
    }
}
