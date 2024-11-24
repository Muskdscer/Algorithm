package com.example.algorithm.kamaCoder.str;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean[][] dp = new boolean[len][len];
        int left=0,right=0,res=0;//记录左右边界和右-左的长度
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if(chars[i] == chars[j] && (j -i <= 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if(j-i>res){
                        res=j-i;//res记得也得更新！
                        left=i;
                        right=j;
                    }
                }
            }
        }
        return s.substring(left,right+1);//左闭右开;
    }
}
