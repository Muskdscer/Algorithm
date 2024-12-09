package com.example.algorithm.kamaCoder.backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Combine3 {
    static int sum = 0;
    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> temp = new LinkedList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        combineNum11(n, k,1);
        for (Integer integer : temp) {
            System.out.print(integer + " ");
        }
    }

    private static void combineNum11(int n, int k, int start) {
        if (sum == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (sum > k) {
            return;
        }

        for (int i = 1; i <= n; i++) {
            temp.add(i);
            sum += i;
            combineNum11(n, k, i + 1);
            sum -= i;
            temp.removeLast();
        }
    }
}
