package com.hchenpan;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Project : CodingInterviews
 * ClassName : com.hchenpan.从头到尾打印链表
 * Description : 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/3/29 下午 09:46
 **/
public class b03_从尾到头打印链表 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        for (Integer integer : printListFromTailToHead(head)) {
            System.out.print(integer + ",");
        }

    }


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //创建空栈
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            //遍历链表并入栈
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        //创建数组列表
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            //出栈并加入数组列表
            list.add(stack.pop());
        }
        return list;
    }
}