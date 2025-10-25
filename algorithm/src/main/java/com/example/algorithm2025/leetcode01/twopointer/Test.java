package com.example.algorithm2025.leetcode01.twopointer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Test {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public void foo(int[] arr, int m, int n) {
        int sum = 0;
        backTracking(arr, m, n, sum, 0);
        for (List<Integer> re : res) {
            System.out.println(re.toArray());
        }
        //ThreadLocal
        ThreadLocal<String> local = new ThreadLocal<>();
        //Lock
        Lock lock = new ReentrantLock();
    }

    private void backTracking(int[] arr, int m, int n, int sum, int index) {
        if (path.size() > m) {
            sum = 0;

        }
        if (sum == n) {
            res.add(path);
            return;
        }
        for (int i = index; i < arr.length; i++) {
            sum += arr[i];
            path.add(arr[i]);
            backTracking(arr, m, n, sum, index + 1);
            sum -= arr[i];
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {

    }
}
