package com.hchenpan;

import org.junit.Test;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Project : Sword2Offer
 * ClassName : com.hchenpan.b65_滑动窗口的最大值
 * Description :
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/11 下午 04:20
 **/
public class b65_滑动窗口的最大值 {
    @Test
    public void test() {
        // expected {7};
        int[] data1 = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(maxInWindows(data1, 10));
        // expected {3, 3, 5, 5, 6, 7};
        int[] data2 = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(maxInWindows(data2, 3));
        // expected {7, 9, 11, 13, 15};
        int[] data3 = new int[]{1, 3, 5, 7, 9, 11, 13, 15};
        System.out.println(maxInWindows(data3, 4));
        // expected  {16, 14, 12};
        int[] data5 = new int[]{16, 14, 12, 10, 8, 6, 4};
        System.out.println(maxInWindows(data5, 5));
        // expected  {10, 14, 12, 11};
        int[] data6 = new int[]{10, 14, 12, 11};
        System.out.println(maxInWindows(data6, 1));
        // expected  {14};
        int[] data7 = new int[]{10, 14, 12, 11};
        System.out.println(maxInWindows(data7, 4));
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (num == null || num.length <= 0 || size < 1) {
            return ret;
        }
        if (num.length < size) {
            int max = num[0];
            for (int i : num) {
                max = Math.max(max, i);
            }
            ret.add(max);
            return ret;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);  /* 大顶堆 */
        for (int i = 0; i < size; i++) {
            heap.add(num[i]);
        }
        ret.add(heap.peek());
        for (int i = 0, j = i + size; j < num.length; i++, j++) {            /* 维护一个大小为 size 的大顶堆 */
            heap.remove(num[i]);
            heap.add(num[j]);
            ret.add(heap.peek());
        }
        return ret;
    }
}