package com.hchenpan;

import org.junit.Test;

import java.util.Stack;

/**
 * Project : SwordOffer
 * ClassName : com.hchenpan.b21_栈的压入$弹出序列
 * Description :
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/3 下午 05:06
 **/
public class b21_栈的压入$弹出序列 {
    @Test
    public void test() {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop1 = {4, 5, 3, 2, 1};
        int[] pop2 = {3, 5, 4, 2, 1};
        int[] pop3 = {4, 3, 5, 1, 2};
        int[] pop4 = {3, 5, 4, 1, 2};
        System.out.println("true: " + IsPopOrder(push, pop1));
        System.out.println("true: " + IsPopOrder(push, pop2));
        System.out.println("false: " + IsPopOrder(push, pop3));
        System.out.println("false: " + IsPopOrder(push, pop4));
        int[] push5 = {1};
        int[] pop5 = {2};
        System.out.println("false: " + IsPopOrder(push5, pop5));
        int[] push6 = {1};
        int[] pop6 = {1};
        System.out.println("true: " + IsPopOrder(push6, pop6));
        System.out.println("false: " + IsPopOrder(null, null));
    }

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < pushA.length; pushIndex++) {
            stack.push(pushA[pushIndex]);
            while (pushIndex < pushA.length &&
                    !stack.isEmpty() &&
                    stack.peek() == popA[popIndex]
            ) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}