package com.example.algorithm.binaryTree.levelOrder;

import java.util.LinkedList;
import java.util.Queue;

public class Connect {
    public PNode connect(PNode root) {
        Queue<PNode> tmpQueue = new LinkedList<PNode>();
        if (root != null) tmpQueue.add(root);

        while (tmpQueue.size() != 0){
            int size = tmpQueue.size();

            PNode cur = tmpQueue.poll();
            if (cur.left != null) tmpQueue.add(cur.left);
            if (cur.right != null) tmpQueue.add(cur.right);

            for (int index = 1; index < size; index++){
                PNode next = tmpQueue.poll();
                if (next.left != null) tmpQueue.add(next.left);
                if (next.right != null) tmpQueue.add(next.right);

                cur.next = next;
                cur = next;
            }
        }
        return root;
    }
}
