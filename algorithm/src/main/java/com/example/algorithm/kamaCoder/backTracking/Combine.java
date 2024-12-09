package com.example.algorithm.kamaCoder.backTracking;

import java.lang.*;
import java.util.*;
import java.io.*;

public class Combine {

    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> temp = new LinkedList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        combineNum(n, k);
        for (List<Integer> list : res) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    private static void combineNum(int n, int k) {
        if (n < k) return;
        backTrackingNum(n, k, 1);
    }

    private static void backTrackingNum(int n, int k, int start) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i <= n - (k - temp.size()) + 1; i++) {
            temp.add(i);
            backTrackingNum(n, k, i + 1);
            //temp.remove(temp.size() - 1);
            temp.removeLast();
        }
    }
}
