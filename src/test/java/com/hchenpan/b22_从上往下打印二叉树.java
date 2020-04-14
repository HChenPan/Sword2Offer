package com.hchenpan;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Project : SwordOffer
 * ClassName : com.hchenpan.b22_从上往下打印二叉树
 * Description :
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/3 下午 10:38
 **/
public class b22_从上往下打印二叉树 {
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
        //       8
        //    /    \
        //   6     10
        //  / \   / \
        // 5   7 9  11
        TreeNode head = new TreeNode(8);
        head.left = new TreeNode(6);
        head.left.left = new TreeNode(5);
        head.left.right = new TreeNode(7);
        head.right = new TreeNode(10);
        head.right.left = new TreeNode(9);
        head.right.right = new TreeNode(11);
        ArrayList<Integer> list = PrintFromTopToBottom(head);
        for (Integer node : list) {
            System.out.print(node + " ");
        }

    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //       8
        //    /    \
        //   6     10
        //  / \   / \
        // 5   7 9  11
        Queue<TreeNode> queue = new LinkedList<>();// 节点队列
        //入队序列:8 6 10 5 7 9 11 null null null null null null null null
        //出队序列:8 6 10 5 7 9 11 null null null null null null null null
        ArrayList<Integer> ret = new ArrayList<>();  //输出集合
        queue.add(root);  //根节点入队
        while (!queue.isEmpty()) {
            int cnt = queue.size();//当前队列长度 防止子树不完整
            while (cnt-- > 0) {
                TreeNode t = queue.poll();//取出当前根    8     6    10    5      7      9      11     null
                if (t == null) {
                    continue;
                }
                ret.add(t.val);//根加入集合                8     6     10   5      7      9       11
                queue.add(t.left); //左节点入队             6     5     9    null   null   null    null
                queue.add(t.right); //右节点入队             10    7    11    null  null    null   null
            }
        }
        return ret;
    }
}