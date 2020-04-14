package com.hchenpan;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Project : SwordOffer
 * ClassName : com.hchenpan.b24_二叉树中和为某一值的路径
 * Description :
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/4 下午 10:52
 **/
public class b24_二叉树中和为某一值的路径 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void test() {
        //            10
        //         /      \
        //        5        12
        //       /\
        //      4  7
        TreeNode head = new TreeNode(10);
        head.left = new TreeNode(5);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(7);
        head.right = new TreeNode(12);
        // 有两条路径上的结点和为22
        System.out.println("FindPath(head, 22);");
        for (ArrayList<Integer> integers : FindPath(head, 22)) {
            System.out.println(integers);
        }
        // 没有路径上的结点和为15
        System.out.println("FindPath(head, 15);");
        for (ArrayList<Integer> integers : FindPath(head, 15)) {
            System.out.println(integers);
        }
        // 有一条路径上的结点和为19
        System.out.println("FindPath(head, 19);");
        for (ArrayList<Integer> integers : FindPath(head, 19)) {
            System.out.println(integers);
        }
        //               5
        //              /
        //             4
        //            /
        //           3
        //          /
        //         2
        //        /
        //       1
        TreeNode head2 = new TreeNode(5);
        head2.left = new TreeNode(4);
        head2.left.left = new TreeNode(3);
        head2.left.left.left = new TreeNode(2);
        head2.left.left.left.left = new TreeNode(1);
        // 有一条路径上面的结点和为15
        System.out.println("FindPath(head2, 15);");
        for (ArrayList<Integer> integers : FindPath(head2, 15)) {
            System.out.println(integers);
        }
        // 没有路径上面的结点和为16
        System.out.println("FindPath(head2, 16);");
        for (ArrayList<Integer> integers : FindPath(head2, 16)) {
            System.out.println(integers);
        }
        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        //        \
        //         5
        TreeNode head3 = new TreeNode(1);
        head3.right = new TreeNode(2);
        head3.right.right = new TreeNode(3);
        head3.right.right.right = new TreeNode(4);
        head3.right.right.right.right = new TreeNode(5);
        // 有一条路径上面的结点和为15
        System.out.println("FindPath(head3, 15);");
        for (ArrayList<Integer> integers : FindPath(head3, 15)) {
            System.out.println(integers);
        }
        // 没有路径上面的结点和为16
        System.out.println("FindPath(head3, 16);");
        for (ArrayList<Integer> integers : FindPath(head3, 16)) {
            System.out.println(integers);
        }
        // 树中只有1个结点
        TreeNode head4 = new TreeNode(1);
        // 有一条路径上面的结点和为1
        System.out.println("FindPath(head4, 1);");
        for (ArrayList<Integer> integers : FindPath(head4, 1)) {
            System.out.println(integers);
        }
        // 没有路径上面的结点和为2
        System.out.println("FindPath(head4, 2);");
        FindPath(head4, 2);
        for (ArrayList<Integer> integers : FindPath(head4, 2)) {
            System.out.println(integers);
        }
        // 树中没有结点
        System.out.println("FindPath(null, 0);");
        for (ArrayList<Integer> integers : FindPath(null, 0)) {
            System.out.println(integers);
        }
    }


    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<Integer> path = new ArrayList<>();//存储遍历的路径
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();//存储符合条件的路径
        if (root == null) {
            return pathList;
        }
        Stack<TreeNode> stack = new Stack<>();//存储前序遍历序列
        TreeNode lastNode;//上一次遍历的节点
        do {
            while (root != null) {
                //遍历根节点的左分支
                path.add(root.val);//节点添加到遍历路径
                target -= root.val;//目标值减去节点值
                stack.push(root);//节点入栈
                root = root.left;//移动到左子树
            }
            while ((stack.peek().val) != (path.get(path.size() - 1))) {
                //避免由于栈中弹出了对应元素，而该元素存在右节点，此时在弹出该元素的右节点之后需要将path跟stack一致，相当于清除操作
                //栈顶元素不等于遍历路径最后一个节点    不符合要求的路径 复原
                target += path.get(path.size() - 1);//目标值复原
                path.remove(path.size() - 1);//路径复原
            }
            if (target == 0 && stack.peek().left == null) {
                //符合条件的遍历路径
                pathList.add(new ArrayList<>(path));
            }
            if (!stack.isEmpty()) {
                //左节点到null之后，需要去找到右节点对应的元素，通过推栈来实现
                root = stack.pop();
                lastNode = root;
                root = root.right;
                if (root == null) {
                    path.remove(path.size() - 1);//复原路径
                    target += lastNode.val;//复原目标值
                }
            }
        } while (root != null || !stack.isEmpty());
        return pathList;
    }
}