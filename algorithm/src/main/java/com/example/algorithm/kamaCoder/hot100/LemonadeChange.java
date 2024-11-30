package com.example.algorithm.kamaCoder.hot100;

public class LemonadeChange {
    public static void main(String[] args) {
        int[] money = new int[]{5, 5, 5, 10, 20};
        boolean flag = canChange(money);
    }

    private static boolean canChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                five--;
                ten++;
            } else if (bills[i] == 20) {
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five -= 3;
                }
            }
            if (five < 0 || ten < 0) return false;
        }

        return true;
    }
}
