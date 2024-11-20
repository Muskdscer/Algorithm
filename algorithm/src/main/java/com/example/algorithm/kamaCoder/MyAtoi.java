package com.example.algorithm.kamaCoder;

public class MyAtoi {
    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        String str = "215474";
        int res = myAtoi.myAtoi(str);
        System.out.println(res);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

    }
    public int myAtoi(String str) {
        int len = str.length();
        char[] charArray = str.toCharArray();

        //去空格
        int index = 0;
        while (index < len && charArray[index] == ' ') {
            index++;
        }

        //如果遍历已经完成(针对极端情况"           ")
        if (index == len) {
            return 0;
        }

        //如果出现符号字符 仅第一个有效 并记录正负
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }
        //将后面出现的数字字符进行转换
        //不能使用long类型
        int res = 0;
        while(index < len) {
            char currChar = charArray[index];
            //判断不合法情况
            if (currChar > '9' || currChar < '0') {
                break;
            }

            //题目中说 环境只能存储32大小的有符号整数 需要提前判断 乘以10后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            //合法情况才考虑抓换 每一步都把符号乘进去
            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;
    }

}
