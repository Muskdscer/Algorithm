package com.example.algorithm.kamaCoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ACMTrain17 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(str);
            int n = Integer.parseInt(tokenizer.nextToken());
            if(n == 0){
                break;
            }
            int[] arr = new int[n];
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(tokenizer.nextToken());
            }
            if(check(arr)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
    public static boolean check(int[] arr){
        int n = arr.length;
        int[] st = new int[n];
        int top = -1;
        int k = 1;
        for(int i = 0; i < n; i++){
            while(top == -1 || st[top] < arr[i]){
                st[++top] = k++;
            }
            if(st[top] != arr[i]){
                return false;
            }
            top--;
        }
        return true;
    }
}
