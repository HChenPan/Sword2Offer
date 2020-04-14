package com.hchenpan;

import org.junit.Test;

import java.util.Arrays;

/**
 * Project : CodingInterviews
 * ClassName : com.hchenpan.b04_重建二叉树
 * Description :
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/3/29 下午 10:08
 **/
public class b04_重建二叉树 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void test() {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        System.out.println(Arrays.toString(pre));
        System.out.println(Arrays.toString(in));
        TreeNode treeNode = reConstructBinaryTree(pre, in);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode treeNode = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return treeNode;
    }

    /**
     * description(描述) 递归实现二叉树重建
     *
     * @param pre      先序序列
     * @param startPre 先序序列开始坐标
     * @param endPre   先序序列结束坐标
     * @param in       中序序列
     * @param startIn  中序序列开始坐标
     * @param endIn    中序序列结束坐标
     * @return com.hchenpan.b04_重建二叉树.TreeNode
     * @author Huangcp
     * @date 2020/3/31 下午 04:19
     **/
    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        //先序序列第一个元素为二叉树根节点
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            //遍历中序序列寻找与根节点相等的元素
            if (in[i] == pre[startPre]) {
                //创建左子树
                //先序序列 根节点往后一位置-> 先序序列开始坐标+中序序列中根节点坐标-中序序列开始坐标
                //中序序列 中序序列开始坐标-> 中序序列中根节点坐标-中序序列开始坐标
                //eg：i=3
                // 1, (2, 4, 7,) 3, 5, 6, 8 |2|3|
                // (4, 7, 2,) 1, 5, 3, 8, 6 |0|2|
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                //创建右子树
                //先序序列 先序序列开始坐标+中序序列中根节点坐标-中序序列开始坐标+1->先序序列结束坐标
                //中序序列 中序序列中根节点坐标+1->中序序列结束坐标
                //eg：i=3
                // 1, 2, 4, 7,( 3, 5, 6, 8) |4|7|
                // 4, 7, 2, 1, (5, 3, 8, 6) |4|7|
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
            }
        }
        return root;
    }
}