package com.example.algorithm.kamaCoder;

import java.util.Scanner;

public class ACMTrain14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                String line = sc.nextLine().trim();
                char[] arr = line.toCharArray();
                StringBuilder sb = new StringBuilder();
                int j = 0;
                while (j < arr.length) {
                    if (arr[j] <= 'z' && arr[j] >= 'a') {
                        arr[j] = Character.toUpperCase(arr[j]);
                    }
                    sb.append(arr[j]);
                    while (j < arr.length && arr[j] != ' ') {
                        j++;
                    }
                    while (j < arr.length && arr[j] == ' ') {
                        j++;
                    }
                }
                System.out.println(sb.toString());
            }
        }
    }
}
