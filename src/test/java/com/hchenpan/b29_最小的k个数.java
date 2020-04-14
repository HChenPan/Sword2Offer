package com.hchenpan;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Project : SwordOffer
 * ClassName : com.hchenpan.b29_最小的k个数
 * Description :
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4,。
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/6 下午 03:55
 **/
public class b29_最小的k个数 {
    @Test
    public void test() {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        System.out.println(Arrays.toString(arr));
        System.out.println("k = " + k);
        ArrayList<Integer> integers = GetLeastNumbers_Solution(arr, k);
        for (Integer integer : integers) {
            System.out.print(integer);
        }
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k > input.length || k <= 0) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //自定义排序，大元素先出队
                return o2 - o1;
            }
        });
        for (int num : input) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();//如果队列长度大于k，最大元素出队列
            }
        }
        return new ArrayList<>(maxHeap);
    }
}