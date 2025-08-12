package com.example.algorithm2025.leetcode01.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//写一个函数 void foo(arr, m, n)，arr是整数数组，m是个数，n是和，打印所有和为n的 二维数组，注意兼顾性能。
//例子：
//arr 为[-1，1，2，3，4，5，6]
//m=2, n=5时，打印 [  [1，4]，[2，3]，[-1，6] ]
//m=3, n=6时，打印[ [-1，1，6], [-1,2,5], [-1,3,4], [1,2,3] ]
public class CombinationSum {
    // 主函数：打印所有和为n的m元素组合
    public static void foo(int[] arr, int m, int n) {
        // 边界条件检查
        if (arr == null || arr.length == 0 || m < 1 || m > arr.length) {
            System.out.println("[]");
            return;
        }

        // 排序数组，便于去重和剪枝
        Arrays.sort(arr);

        // 存储结果的列表
        List<List<Integer>> result = new ArrayList<>();

        // 调用回溯函数寻找所有符合条件的组合
        backtrack(arr, 0, m, n, new ArrayList<>(), result);

        // 打印结果
        printResult(result);
    }

    // 回溯函数：寻找符合条件的组合
    private static void backtrack(int[] arr, int start, int remainingCount, int remainingSum,
                                  List<Integer> path, List<List<Integer>> result) {
        // 递归终止条件：已选够m个元素
        if (remainingCount == 0) {
            // 检查和是否等于n
            if (remainingSum == 0) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        // 遍历数组，从start开始避免重复选择
        for (int i = start; i < arr.length; i++) {
            // 去重：跳过与前一个元素相同的元素
            if (i > start && arr[i] == arr[i - 1]) {
                continue;
            }

            // 剪枝：当前元素大于剩余和，后续元素更大，无需继续
            if (arr[i] > remainingSum) {
                break;
            }

            // 选择当前元素
            path.add(arr[i]);

            // 递归寻找剩余元素：剩余数量减1，剩余和减当前元素值，起始索引+1
            backtrack(arr, i + 1, remainingCount - 1, remainingSum - arr[i], path, result);

            // 回溯：移除最后选择的元素
            path.remove(path.size() - 1);
        }
    }

        // 打印结果，格式如[[a,b], [c,d]]
        private static void printResult(List<List<Integer>> result) {
            if (result.isEmpty()) {
                System.out.println("[]");
                return;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < result.size(); i++) {
                List<Integer> combination = result.get(i);
                sb.append("[");
                for (int j = 0; j < combination.size(); j++) {
                    sb.append(combination.get(j));
                    if (j != combination.size() - 1) {
                        sb.append(", ");
                    }
                }
                sb.append("]");
                if (i != result.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            System.out.println(sb.toString());
        }

        // 测试示例
        public static void main(String[] args) {
            int[] arr = {-1, 1, 2, 3, 4, 5, 6};

            // 测试案例1：m=2, n=5
            System.out.println("m=2, n=5时的结果：");
            foo(arr, 2, 5);

            // 测试案例2：m=3, n=6
            System.out.println("m=3, n=6时的结果：");
            foo(arr, 3, 6);
        }
}
