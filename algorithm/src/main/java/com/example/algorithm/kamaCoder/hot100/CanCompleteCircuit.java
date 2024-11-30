package com.example.algorithm.kamaCoder.hot100;

public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int index = 0;

        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                index = (i + 1) % gas.length;
                curSum = 0;
            }
        }

        if (totalSum < 0) {
            return -1;
        }
        return index;
    }
}
