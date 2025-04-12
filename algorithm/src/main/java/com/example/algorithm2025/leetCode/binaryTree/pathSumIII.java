package com.example.algorithm2025.leetCode.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class pathSumIII {
    int res = 0;
    // map用来存放当前递归分支上已经出现过的前缀和。注意节点的取值范围要使用Long
    Map<Long,Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        // 注意先在map中放入0，不然当前缀和正好等于 targerSum 时没法被计入 res。
        // 注意这里要做 int -> Long 的类型转换
        map.put(0L, 1);
        traversal(root, targetSum, 0L);
        return res;
    }

    // 由于节点值的范围是Long，所以节点的和的类型也应该是Long
    private void traversal(TreeNode root, int targetSum, Long sum) {
        // 参数sum表示前缀和（从根节点到当前节点的所有节点之和）
        if (root == null) {
            return;
        }

        sum += root.val;
        if (map.containsKey(sum - targetSum)) {
            res += map.get(sum-targetSum);
        }
        map.put(sum, map.getOrDefault(sum, 0)+1);
        //sum不是全局变量
        //而必须是递归函数的参数。否则在这里向左递归后，
        // sum的值的变化会影响到接下来向右递归时sum的大小
        traversal(root.left, targetSum, sum);
        traversal(root.right, targetSum, sum);

        //回溯 因为sum是递归函数参数
        //每个递归分支的sum之间互相独立，所以不用再手动回溯sum的值，只需要手动回溯map就够了
        map.put(sum, map.get(sum)-1);
    }
}
