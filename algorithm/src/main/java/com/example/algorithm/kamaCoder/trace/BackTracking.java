package com.example.algorithm.kamaCoder.trace;

import java.util.*;
import java.lang.*;
import java.io.*;

public class BackTracking {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();
    public static void main(String[] args) {
        res = back(4, 2);
    }

    private static List<List<Integer>> back(int n, int k) {
        backTrace(n, k, 1);
        return res;
    }

    private static void backTrace(int n, int k, int startIndex) {
        if (temp.size() == k) {
            res.add(temp);
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            temp.add(i);
            backTrace(n, k, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
