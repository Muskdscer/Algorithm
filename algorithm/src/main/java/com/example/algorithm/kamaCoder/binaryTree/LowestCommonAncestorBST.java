package com.example.algorithm.kamaCoder.binaryTree;

public class LowestCommonAncestorBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode(TreeNode left, TreeNode right, int val) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        TreeNode node = ancestor(root, node3, node4);
        System.out.println("祖先为：" + node.val);
    }

    private static TreeNode ancestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            ancestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            ancestor(root.right, p, q);
        }
        return root;
    }
}
