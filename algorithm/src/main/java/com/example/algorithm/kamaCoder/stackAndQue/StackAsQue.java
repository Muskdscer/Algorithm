package com.example.algorithm.kamaCoder.stackAndQue;

import java.lang.*;
import java.util.*;
import java.io.*;

public class StackAsQue {
    static class MyQueue{
        Stack<Integer> stackIn;
        Stack<Integer> stackOut;

        public MyQueue() {
            stackIn = new Stack<>();
            stackOut = new Stack<>();
        }

        public void push(int val) {
            stackIn.push(val);
        }

        public int pop() {
            dumpstackIn();
            return stackOut.pop();
        }

        public int peek() {
            dumpstackIn();
            return stackOut.peek();
        }

        public boolean empty() {
            return stackIn.isEmpty() && stackOut.isEmpty();
        }



        private void dumpstackIn() {
            //如果stackOut为空 stackIn中的元素全部放入stackOut
            if (!stackOut.isEmpty()) {
                return;
            }
            while (!stackIn.isEmpty()) {
                Integer pop = stackIn.pop();
                stackOut.push(pop);
            }
        }
    }


    public static void main(String[] args) {

    }
}
