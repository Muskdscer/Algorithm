package com.example.algorithm.leetcode;

import java.util.*;

/**
 * ArrayDeque 是 Java 集合中双端队列的数组实现，双端队列的链表实现（LinkedList）
 *  1.添加元素
 *         addFirst(E e)在数组前面添加元素
 *         addLast(E e)在数组后面添加元素
 *         offerFirst(E e) 在数组前面添加元素，并返回是否添加成功
 *         offerLast(E e) 在数组后天添加元素，并返回是否添加成功
 *
 *   2.删除元素
 *         removeFirst()删除第一个元素，并返回删除元素的值,如果元素为null，将抛出异常
 *         pollFirst()删除第一个元素，并返回删除元素的值，如果元素为null，将返回null
 *         removeLast()删除最后一个元素，并返回删除元素的值，如果为null，将抛出异常
 *         pollLast()删除最后一个元素，并返回删除元素的值，如果为null，将返回null
 *         removeFirstOccurrence(Object o) 删除第一次出现的指定元素
 *         removeLastOccurrence(Object o) 删除最后一次出现的指定元素
 *
 *
 *    3.获取元素
 *         getFirst() 获取第一个元素,如果没有将抛出异常
 *         getLast() 获取最后一个元素，如果没有将抛出异常
 *
 *
 *     4.队列操作
 *         add(E e) 在队列尾部添加一个元素
 *         offer(E e) 在队列尾部添加一个元素，并返回是否成功
 *         remove() 删除队列中第一个元素，并返回该元素的值，如果元素为null，将抛出异常(其实底层调用的是removeFirst())
 *         poll()  删除队列中第一个元素，并返回该元素的值,如果元素为null，将返回null(其实调用的是pollFirst())
 *         element() 获取第一个元素，如果没有将抛出异常
 *         peek() 获取第一个元素，如果返回null
 *
 *
 *     5.栈操作
 *         push(E e) 栈顶添加一个元素
 *         pop(E e) 移除栈顶元素,如果栈顶没有元素将抛出异常
 *
 *
 *     6.其他
 *         size() 获取队列中元素个数
 *         isEmpty() 判断队列是否为空
 *         iterator() 迭代器，从前向后迭代
 *         descendingIterator() 迭代器，从后向前迭代
 *         contain(Object o) 判断队列中是否存在该元素
 *         toArray() 转成数组
 *         clear() 清空队列
 *         clone() 克隆(复制)一个新的队列
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;
        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    //往结果里添加的时候，从尾部添加
                    levelList.offerLast(curNode.val);
                } else {
                    //往结果里添加的时候，从头部添加
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<>(levelList));
            isOrderLeft = !isOrderLeft;
        }
        return ans;
    }
}
