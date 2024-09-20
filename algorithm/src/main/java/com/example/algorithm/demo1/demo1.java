package com.example.algorithm.demo1;

import lombok.Builder;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Builder
public class demo1 {
    /**
     * 前序遍历
     * @param root
     * @return
     */
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        pre(root,list);
        return list;
    }

    private void pre(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        pre(root.left,list);
        pre(root.right,list);
    }

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public List<Integer> midOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        mid(root,list);
        return list;
    }

    private void mid(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        mid(root.left,list);
        list.add(root.val);
        mid(root.right,list);
    }

    //111.二叉树的最小深度
    //递归法
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = minDepth1(root.left);
        int rightDepth = minDepth1(root.right);
        if (root.left == null) {
            return rightDepth + 1;
        }
        if (root.right == null) {
            return leftDepth + 1;
        }
        //左右节点都不为空
        return Math.min(leftDepth, rightDepth) + 1;
    }

    //迭代法
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll.left == null && poll.right == null) {
                    //叶子节点直接返回depth, 因为从上向下遍历，所以该值就是最小值
                    return depth;
                }
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }
        }
        return depth;
    }


    //222.完全二叉树的节点个数
    //按照普通二叉树的逻辑
    public int getNodesNum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftNum = getNodesNum(root.left);
        int rightNum = getNodesNum(root.right);
        int treeNum = leftNum + rightNum + 1;
        return treeNum;
    }
    //迭代法
    public int getNodesNum1(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        if (root != null) {
            que.offer(root);
        }
        int result = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = que.poll();
                result++;
                if (poll.left != null) {
                    que.offer(poll.left);
                }
                if (poll.right != null) {
                    que.offer(poll.right);
                }
            }
        }
        return result;
    }

    //按照完全二叉树
    public int getNodesNums2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        //初始为0是有目的的，为了下面求指数方便
        int leftDepth = 0 , rightDepth = 0;
        //求左子树深度
        while (left != null) {
            left = left.left;
            leftDepth++;
        }
        //求右子树深度
        while (right != null) {
            right = right.right;
            rightDepth++;
        }
        if (leftDepth == rightDepth) {
            return (2 << leftDepth) - 1;
        }
        return getNodesNums2(root.left) + getNodesNums2(root.right) + 1;
    }

    //112. 路径总和
    //递归法
    public boolean hasPathsum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        //叶子结点
        if (root.left == null && root.right == null) {
            return false;
        }
        if (root.left != null) {
            boolean left = hasPathsum(root.left, targetSum);
            if (left) {
                //已经找到
                return true;
            }
        }
        if (root.right != null) {
            boolean right = hasPathsum(root.right, targetSum);
            if (right) {
                //已经找到
                return true;
            }
        }
        return false;
    }
    //简洁法
    public boolean hasPathsum1(TreeNode root, int targetsum) {
        if (root == null) {
            //为空退出
            return false;
        }

        //叶子结点判断是否符合
        if (root.left != null && root.right != null) {
            return root.val == targetsum;
        }

        //求两侧分支的路径和
        return hasPathsum(root.left, targetsum - root.val) || hasPathsum(root.right, targetsum - root.val);
    }


    //113. 路径总和ii
    //解法一
    public List<List<Integer>> pathSum(TreeNode root, int targetsum) {
        List<List<Integer>> res = new ArrayList<>();
        //非空判断
        if (root == null) {
            return res;
        }

        List<Integer> path = new LinkedList<>();
        preorderdfs(root, targetsum, res, path);
        return res;
    }

    private void preorderdfs(TreeNode root, int targetsum, List<List<Integer>> res, List<Integer> path) {
        path.add(root.val);
        //遇到叶子结点
        if (root.left == null && root.right == null) {
            //找到了和为targetsum的路径
            if (targetsum - root.val == 0) {
                res.add(new ArrayList<>(path));
            }
            //如果和不为 targetsum 返回
            return;
        }

        //左
        if (root.left != null) {
            preorderdfs(root.left, targetsum - root.val, res, path);
            //回溯
            path.remove(path.size() - 1);
        }
        //右
        if (root.right != null) {
            preorderdfs(root.right, targetsum - root.val, res, path);
            //回溯
            path.remove(path.size() - 1);
        }
    }

    //解法二
    List<List<Integer>> result;
    LinkedList<Integer> path;
    public List<List<Integer>> pathSum1(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        path = new LinkedList<>();
        traversal(root, targetSum);
        return result;
    }

    private void traversal(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.offer(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            result.add(new LinkedList<>(path));
        }
        traversal(root.left, targetSum);
        traversal(root.right, targetSum);
        //回溯
        path.removeLast();
    }

    //106.从中序与后序遍历序列构造二叉树
    //方便根据数值找位置
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        //map用于保存中序遍历数值对应位置
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        //参数里的范围都是左闭右开
        if (inBegin >= inEnd || postBegin >= postEnd) {
            return null;
        }

        //找到后续遍历的最后一个元素在中序遍历中的位置
        int rootIndex = map.get(postorder[postEnd - 1]);
        //构造节点
        TreeNode root = new TreeNode(inorder[rootIndex]);
        //确定中序左子树个数，用于确定后序数列个数
        int lenOfLeft = rootIndex - inBegin;
        root.left = findNode(inorder, inBegin, rootIndex, postorder, postBegin, postBegin + lenOfLeft);
        root.right = findNode(inorder, rootIndex + 1, inEnd, postorder, postBegin + lenOfLeft, postEnd - 1);

        return root;
    }

    //使用后序和中序构造二叉树， 解法二
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return buildHelper(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode buildHelper(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postStart, int postEnd) {
        if (postStart == postEnd) {
            return null;
        }
        return null;
    }


    //654.最大二叉树
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree1(nums, 0, nums.length);
    }

    private TreeNode constructMaximumBinaryTree1(int[] nums, int leftIndex, int rightIndex) {
        //没有元素了
        if (rightIndex - leftIndex == 0) {
            return null;
        }
        //只有一个元素
        if (rightIndex - leftIndex == 1) {
            return new TreeNode(nums[leftIndex]);
        }

        //最大值所在位置
        int maxIndex = leftIndex;
        //最大值
        int maxVal = nums[maxIndex];
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = constructMaximumBinaryTree1(nums, leftIndex, maxIndex);
        root.right = constructMaximumBinaryTree1(nums, maxIndex + 1, rightIndex);
        return root;
    }

    //617.合并二叉树
    //递归
    public TreeNode mergeTree(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
             return root1;
        }

        root1.val += root2.val;
        root1.left = mergeTree(root1.left, root2.left);
        root1.right = mergeTree(root1.right, root2.right);
        return root1;
    }

    //使用栈迭代
//    public TreeNode mergeTree1(TreeNode root1, TreeNode root2) {
//        if (root1 == null) {
//             return root2;
//        }
//        if (root2 == null) {
//            return root1;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root2);
//        stack.push(root1);
//        while (!stack.isEmpty()) {
//            TreeNode node1 = stack.pop();
//            TreeNode node2 = stack.pop();
//            node1.val += node2.val;
//            if (node1.right != null && node2.right != null) {
//                stack.push(node2.right);
//                stack.push(node1.right);
//            } else {
//                if (node1.right == null) {
//                    node1.right = node2.right;
//                }
//            }
//        }
//
//    }


    //98.验证二叉搜索树

    //501.二叉搜索树中的众数
    int count;
    int maxCount;
    TreeNode pre;//记录前一个节点
    List<Integer> bstResult;
    public List<Integer> findNode(TreeNode root) {
        count = 0;
        maxCount = 0;
        pre = null;
        bstResult = new ArrayList<>();
        searchBST(root);
        return bstResult;
    }

    private void searchBST(TreeNode root) {
        if (root == null) {
            return;
        }

        searchBST(root.left);//左

        //中
        if (pre == null) {//第一个节点
            count = 1;
        } else if (pre.val == root.val) {//与前一个节点数值相同
            count++;
        } else {//与前一个节点数值不同
            count = 1;
        }
        pre = root;//更新上一个节点

        if (count == maxCount) {//如果为最大值放进result中
            bstResult.add(root.val);
        }
        if (count > maxCount) {//如果计数大于最大频率值
            maxCount = count;//更新最大频率
            bstResult.removeAll(bstResult);//很关键的一步 不要忘记清空bstResult
            // 之前的bstResult元素都是失效了
            bstResult.add(root.val);
        }

        searchBST(root.right);//右
        return;
    }


    //暴力法
    public int[] findNode1(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
        //获得频率map
        searchBST1(root, map);
        List<Map.Entry<Integer, Integer>> mapList = map.entrySet().stream()
                .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue())).collect(Collectors.toList());
        list.add(mapList.get(0).getKey());
        //把频率最高的加入list
        for (int i = 1; i < mapList.size(); i++) {
            if (mapList.get(i).getValue() == mapList.get(i - 1).getValue()) {
                list.add(mapList.get(i).getKey());
            } else {
                break;
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void searchBST1(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }

        map.put(root.val, map.getOrDefault(root.val,0) + 1);
        searchBST1(root.left, map);
        searchBST1(root.right, map);
    }

    //中序遍历 不需要额外空间
    ArrayList<Integer> bstList;
    int maxCount1;
    int count1;
    TreeNode pre1;

    public int[] findNode2(TreeNode root) {
        bstList = new ArrayList<>();
        maxCount = 0;
        count = 0;
        pre = null;
        findNode3(root);
        int[] res = new int[bstList.size()];
        for (int i = 0; i < bstList.size(); i++) {
            res[i] = bstList.get(i);
        }
        return res;
    }

    private void findNode3(TreeNode root) {
        if (root == null) {
            return;
        }

        findNode3(root.left);

        int rootVal = root.val;
        //计数
        if (pre == null || rootVal != pre.val) {
            count = 1;
        } else {
            count++;
        }

        //更新结果以及maxCount;
        if (count > maxCount) {
            bstList.clear();
            bstList.add(rootVal);
            maxCount = count;
        } else if (count == maxCount) {
            bstList.add(rootVal);
        }
        pre = root;

        findNode3(root.right);
    }


    //236. 二叉树的最近公共祖先

    //701.二叉搜索树中的插入操作
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {//如果当前节点为空，也就意味着val找到了合适的未知，此时创建节点直接返回
            return new TreeNode(val);
        }

        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    //131.分割回文串


    //78.子集
    List<List<Integer>> resultNum = new ArrayList<>();
    LinkedList<Integer> pathNum = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        subsetsHelper(nums, 0);
        return resultNum;
    }

    private void subsetsHelper(int[] nums, int startIndex) {
        resultNum.add(new ArrayList<>(pathNum));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            pathNum.add(nums[i]);
            subsetsHelper(nums, i +1);
            pathNum.removeLast();
        }
    }

    //90.子集II
    List<List<Integer>> result2 = new ArrayList<>();
    LinkedList<Integer> path2 = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            result2.add(path2);
            return result2;
        }

        Arrays.sort(nums);
        used = new boolean[nums.length];
        subsetsWithDupHelper(nums, 0);
        return result2;
    }

    private void subsetsWithDupHelper(int[] nums, int startIndex) {
        result2.add(new ArrayList<>(path2));
        if (startIndex >= nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (i> 0 && nums[i] == nums[i - 1] && !used[i -1]) {
                continue;
            }
            path2.add(nums[i]);
            used[i] = true;
            subsetsWithDupHelper(nums, i + 1);
            path2.removeLast();
            used[i] = false;
        }
    }

    //491.递增子序列

    //45.跳跃游戏 II
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }

        //记录跳跃次数
        int count = 0;
        //当前的最大覆盖区域
        int curDistance = 0;
        //最大覆盖区域
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            //在可覆盖区域内更新最大覆盖区域
            maxDistance = Math.max(maxDistance, i + nums[i]);
            //说明当前一步，再跳一步就到达了末尾
            if (maxDistance >= nums.length - 1) {
                count++;
                break;
            }

            //走到当前覆盖的最大区域，更新下一步可达的最大区域
            if (i == curDistance) {
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }

    //1005.K次取反后最大化的数组和
    public int largestSumAfterNegations(int[] nums, int k) {
        //按绝对值从小到大排列
        IntStream.of(nums).boxed().sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1)).mapToInt(Integer::intValue).toArray();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            //从前向后遍历，遇到负数变成整数，同时K--
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }

        //如果k还大于0，则反复转变数值最小元素，将K用完
        if (k % 2 == 1 ) {
            nums[length - 1] = -nums[length - 1];
        }
        return Arrays.stream(nums).sum();
    }

    //134. 加油站
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                index = (i + 1) % gas.length;
                curSum = 0;
            }
        }
        if (totalSum < 0) {
            return -1;
        }
        return index;
    }

    //860.柠檬水找零
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                five--;
                ten++;
            } else if (bills[i] == 20) {
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five -= 3;
                }
            }

            if (five < 0 || ten < 0) {
                return false;
            }
        }
        return true;
    }

    //406.根据身高重建队列
    public int[][] reconstructQueen(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] -b[0];
        });

        LinkedList<int[]> que = new LinkedList<>();
        for (int[] p : people) {
            que.add(p[1], p); //Linkedlist.add(index, value)，會將value插入到指定index裡。
        }
        return que.toArray(new int[people.length][]);
    }


    //452. 用最少数量的箭引爆气球
    public int findMinArrowShots(int[][] points) {
        //根据气球直径开始坐标从小到大排序
        //使用Integer内置比较方法，不会溢出
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 1;//points不为空至少需要一支箭
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) {
                //气球i和气球i-1不挨着
                count++;
            } else {
                //气球i和气球i-1挨着
                points[i][1] = Math.min(points[i- 1][1], points[i][1]);
            }
        }
        return count;
    }



//    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(5, null, null);
//        System.out.println(treeNode.val);
//    }
}
