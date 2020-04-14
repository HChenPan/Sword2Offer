package com.hchenpan;

import org.junit.Test;

import java.util.Stack;

/**
 * Project : SwordOffer
 * ClassName : com.hchenpan.b05_用两个栈实现队列
 * Description : 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/3/31 下午 04:43
 **/
public class b05_用两个栈实现队列 {
    @Test
    public void test() {
        QueueWithTwoStacks test = new QueueWithTwoStacks();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
    }

    private static class QueueWithTwoStacks {
        /**
         * 入队栈
         */
        Stack<Integer> stack1 = new Stack<Integer>();
        /**
         * 出队栈
         */
        Stack<Integer> stack2 = new Stack<Integer>();

        /**
         * 入队
         */
        public void push(int node) {
            stack1.push(node);
        }

        /**
         * 出队
         */
        public int pop() {
            //遍历入队栈 逆序压入出队栈 并清空入队栈
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            //取出出队栈的上层元素
            int first = stack2.pop();
            //遍历出队栈 逆序压入入队栈 并清空出队栈
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return first;
        }
    }
}