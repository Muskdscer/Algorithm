package com.example.algorithm.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combine {
    List<List<Integer>> result= new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
        return result;
    }

    public void backtracking(int n,int k,int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            path.add(i);
            backtracking(n,k,i+1);
            path.removeLast();
        }
    }
}
