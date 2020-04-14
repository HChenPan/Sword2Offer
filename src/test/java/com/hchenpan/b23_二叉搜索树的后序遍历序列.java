package com.hchenpan;

import org.junit.Test;

import java.util.Arrays;

/**
 * Project : SwordOffer
 * ClassName : com.hchenpan.b23_二叉搜索树的后序遍历序列
 * Description :
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/4 下午 09:37
 **/
public class b23_二叉搜索树的后序遍历序列 {
    @Test
    public void test() {
        //           10
        //         /   \
        //        6     14
        //       /\     /\
        //      4  8  12  16
        int[] squence = {4, 8, 6, 12, 16, 14, 10};
        System.out.println("true: " + VerifySquenceOfBST(squence));
        //           5
        //          / \
        //         4   7
        //            /
        //           6
        int[] squence2 = {4, 6, 7, 5};
        System.out.println("true: " + VerifySquenceOfBST(squence2));
        //               5
        //              /
        //             4
        //            /
        //           3
        //          /
        //         2
        //        /
        //       1
        int[] squence3 = {1, 2, 3, 4, 5};
        System.out.println("true: " + VerifySquenceOfBST(squence3));
        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        //        \
        //         5
        int[] squence4 = {5, 4, 3, 2, 1};
        System.out.println("true: " + VerifySquenceOfBST(squence4));
        // 树中只有1个结点
        int[] squence5 = {5};
        System.out.println("true: " + VerifySquenceOfBST(squence5));
        int[] squence6 = {7, 4, 6, 5};
        System.out.println("false: " + VerifySquenceOfBST(squence6));
        int[] squence7 = {4, 6, 12, 8, 16, 14, 10};
        System.out.println("false: " + VerifySquenceOfBST(squence7));
    }

    public boolean VerifySquenceOfBST(int[] sequence) {
        int len = sequence.length;
        if (len == 0) {
            //序列为空
            return false;
        }
        int root = sequence[len - 1];//当前根节点
        int i = 0;
        while (i < len - 1) {
            //遍历序列寻找右子树
            if (sequence[i] > root) {
                //右子树大于根节点
                break;
            }
            i++;
        }
        int j = i;
        while (j < len - 1) {
            //遍历余下的序列判断是否都大于根节点
            if (sequence[j] < root) {
                return false;
            }
            j++;
        }
        boolean left = true, right = true;
        if (i > 0) {
            left = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));//较小序列判定符合左子树
        }
        if (i < len - 1) {
            right = VerifySquenceOfBST(Arrays.copyOfRange(sequence, i, len - 1));//较大序列判定符合右子树
        }
        return left && right;
    }


}