package com.hchenpan;

import org.junit.Test;

import java.util.Stack;

/**
 * Project : SwordOffer
 * ClassName : com.hchenpan.b20_包含min函数的栈
 * Description :
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/3 下午 03:52
 **/
public class b20_包含min函数的栈 {
    @Test
    public void test() {
        StackWithMin stack = new StackWithMin();
        stack.push(3);
        System.out.println(stack.min() == 3);
        stack.push(4);
        System.out.println(stack.min() == 3);
        stack.push(2);
        System.out.println(stack.min() == 2);
        stack.push(3);
        System.out.println(stack.min() == 2);
        stack.pop();
        System.out.println(stack.min() == 2);
        stack.pop();
        System.out.println(stack.min() == 3);
        stack.push(0);
        System.out.println(stack.min() == 0);
    }

    public static class StackWithMin {
        private Stack<Integer> dataStack = new Stack<>();//主数据栈
        private Stack<Integer> minStack = new Stack<>();          //辅助栈存放数据栈最小元素坐标

        public void push(int node) {
            if (dataStack.isEmpty()) {
                dataStack.push(node);
                minStack.push(0);
            } else {
                dataStack.push(node);
                Integer currentMin = dataStack.get(minStack.peek());//根据辅助栈栈顶坐标读取数据栈对应坐标元素
                minStack.push(node <= currentMin ? dataStack.size() - 1 : minStack.peek());
            }
        }

        public void pop() {
            minStack.pop();
            dataStack.pop();
        }

        public int top() {
            return dataStack.peek();
        }

        public int min() {
            return dataStack.get(minStack.peek());
        }
    }
}