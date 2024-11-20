package com.example.algorithm.kamaCoder;

import java.util.Scanner;

public class ACMTrain13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String line = sc.nextLine();
            if (line.equals("@"))
                break;

            String[] inputs = line.split(" ");
            char ch = inputs[0].charAt(0);
            int n = Integer.parseInt(inputs[1]);

            // 输出图案
            printPattern(ch, n);
        }
        sc.close();
    }

    private static void printPattern(char ch, int n) {
        // 输出第一行
        print(' ', n - 1);
        System.out.println(ch);

        // 输出第二行到倒数第二行
        for (int i = 2; i < n; i++) {
            print(' ', n - i);
            System.out.print(ch);
            print(' ', 2 * i - 3);
            System.out.println(ch);
        }

        // 输出最后一行
        if (n > 1) {
            print(ch, 2 * n - 1);
            System.out.println();
        }

        System.out.println();
    }

    private static void print(char ch, int count) {
        while (count-- > 0) {
            System.out.print(ch);
        }
    }
}
