package com.example.algorithm.kamaCoder;

import java.util.HashMap;
import java.util.Scanner;

public class ACMTrain23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            String preOrder = sc.next();
            String inorder = sc.next();

            HashMap<Character, Integer> inOrderMap = new HashMap<>();
            for (int i = 0; i < n; i++)  {
                inOrderMap.put(inorder.charAt(i), i);
            }

            TreeNode root = buildTree(preOrder, 0, n -1, 0, n -1, inOrderMap);
            int height = getHeight(root);
            System.out.println(height);
        }
        sc.close();
    }

    private static TreeNode buildTree(String preOrder,int preStart, int preEnd,
                                      int inStart, int inEnd, HashMap<Character, Integer> inOrderMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        char rootVal = preOrder.charAt(preStart);
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = inOrderMap.get(rootVal);
        int leftSubtreeSize = rootIndex - inStart;

        root.left = buildTree(preOrder, preStart + 1, preStart + leftSubtreeSize, inStart, rootIndex - 1, inOrderMap);
        root.right = buildTree(preOrder, preStart + leftSubtreeSize + 1, preEnd, rootIndex + 1, inEnd, inOrderMap);

        return root;
    }

    private static int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
