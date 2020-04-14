package com.hchenpan;

import org.junit.Test;

import java.util.HashMap;

/**
 * Project : SwordOffer
 * ClassName : com.hchenpan.b25_复杂链表的复制
 * Description :
 * 输入一个复杂链表
 * （每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/4 下午 11:52
 **/
public class b25_复杂链表的复制 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    @Test
    public void test() {
        //          -----------------
        //         \|/              |
        //  1-------2-------3-------4-------5
        //  |       |      /|\             /|\
        //  --------+--------               |
        //          -------------------------
        RandomListNode head = new RandomListNode(1);

        head.next = new RandomListNode(2);

        head.next.next = new RandomListNode(3);

        head.next.next.next = new RandomListNode(4);

        head.next.next.next.next = new RandomListNode(5);

        head.random = head.next.next;
        head.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next;
        printList(head);
        RandomListNode newHead = Clone(head);
        printList(newHead);

        // 有指向自身的情况
        //          -----------------
        //         \|/              |
        //  1-------2-------3-------4-------5
        //         |       | /|\           /|\
        //         |       | --             |
        //         |------------------------|
        RandomListNode head2 = new RandomListNode(1);

        head2.next = new RandomListNode(2);

        head2.next.next = new RandomListNode(3);

        head2.next.next.next = new RandomListNode(4);

        head2.next.next.next.next = new RandomListNode(5);

        head2.next.random = head2.next.next.next.next;
        head2.next.next.next.random = head2.next.random;
        head2.next.next.random = head2.next.next;
        System.out.println("\n");
        printList(head2);
        RandomListNode newHead2 = Clone(head2);
        printList(newHead2);

        RandomListNode head3 = new RandomListNode(1);

        System.out.println("\n");
        printList(head3);
        RandomListNode newHead3 = Clone(head3);
        printList(newHead3);

        System.out.println("\n");
        RandomListNode head4 = Clone(null);
        printList(head4);
    }

    public RandomListNode Clone(RandomListNode pHead) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();//键值对 原节点：新节点(仅保存label)
        RandomListNode cur = pHead;
        while (cur != null) {
            //复制节点
            map.put(cur, new RandomListNode(cur.label));//当前节点：新建节点label一致
            cur = cur.next;
        }
        cur = pHead;
        while (cur != null) {
            //复制旧结点关系
            (map.get(cur)).next = map.get(cur.next);//新链表中当前节点的 next = map中与旧结点next相同label的新节点
            (map.get(cur)).random = map.get(cur.random);//新链表中当前节点的 random = map中与旧结点random相同label的新节点
            cur = cur.next;
        }
        return map.get(pHead);
    }

    private static void printList(RandomListNode head) {

        RandomListNode cur = head;
        System.out.println("order: ");
        while (cur != null) {
            System.out.print(cur.label + "-> ");
            cur = cur.next;
        }
        System.out.println("null");
        cur = head;
        System.out.println("random:  ");
        while (cur != null) {
            System.out.println(cur.label + ".random -> " + (cur.random == null ? "null" : cur.random.label));
            cur = cur.next;
        }

    }
}