package com.hchenpan;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Project : Sword2Offer
 * ClassName : com.hchenpan.b59_按之字形顺序打印二叉树
 * Description :
 * 实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，        -->
 * 第二层按照从右至左的顺序打印，          <--
 * 第三行按照从左到右的顺序打印，          -->
 * 其他行以此类推
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/11 下午 02:24
 **/
public class b59_按之字形顺序打印二叉树 {
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
        //      1
        //   2    3
        // 4  5  6  7
        //8 9
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;
        ArrayList<ArrayList<Integer>> arrayLists = Print(n1);
        for (ArrayList<Integer> arrayList : arrayLists) {
            System.out.println(arrayList);
        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean reverse = false;//是否需要逆序
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();//理论上当前层元素个数
            while (cnt-- > 0) {
                //遍历当前层元素 均为从左至右
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                list.add(node.val);
                //下一层元素入队列
                queue.add(node.left);
                queue.add(node.right);
            }
            if (reverse) {
                Collections.reverse(list);  //逆序
            }
            reverse = !reverse;
            if (list.size() != 0) {
                ret.add(list);
            }
        }
        return ret;
    }
}