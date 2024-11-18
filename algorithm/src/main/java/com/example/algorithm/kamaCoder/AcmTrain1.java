package com.example.algorithm.kamaCoder;

import java.util.Scanner;

public class AcmTrain1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.print(a + b);
        }
    }
}
