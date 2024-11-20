package com.example.algorithm.kamaCoder;
 import java.io.*;
 import java.util.StringTokenizer;

public class ACMTrain16 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(str);
            int n = Integer.parseInt(st.nextToken());

            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < s.length(); j+= 2){
                    sb.append(s.charAt(j +1)).append(s.charAt(j));
                }
                System.out.println(sb.toString());
            }

        }
    }
}
