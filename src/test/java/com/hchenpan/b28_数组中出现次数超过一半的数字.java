package com.hchenpan;

import org.junit.Test;

/**
 * Project : SwordOffer
 * ClassName : com.hchenpan.b28_数组中出现次数超过一半的数字
 * Description :
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/6 下午 03:38
 **/
public class b28_数组中出现次数超过一半的数字 {
    @Test
    public void test() {
        // 存在出现次数超过数组长度一半的数字
        int numbers[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(MoreThanHalfNum_Solution(numbers));
        // 出现次数超过数组长度一半的数字都出现在数组的前半部分
        int numbers2[] = {2, 2, 2, 2, 2, 1, 3, 4, 5};
        System.out.println(MoreThanHalfNum_Solution(numbers2));
        // 出现次数超过数组长度一半的数字都出现在数组的后半部分
        int numbers3[] = {1, 3, 4, 5, 2, 2, 2, 2, 2};
        System.out.println(MoreThanHalfNum_Solution(numbers3));
        // 只有一个数
        int numbers4[] = {1};
        System.out.println(MoreThanHalfNum_Solution(numbers4));
        // 输入空指针
        //MoreThanHalfNum_Solution(null);
        // 不存在出现次数超过数组长度一半的数字
        int numbers5[] = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        //MoreThanHalfNum_Solution(numbers5);
    }

    public int MoreThanHalfNum_Solution(int[] array) {
        int majority = array[0]; //假定第一个元素是次数最多的
        //1, 2, 3, 2, 2, 2, 5, 4, 2
        for (int i = 1, cnt = 1; i < array.length; i++) {
            //如果当前元素等于最多次元素 计数器 cnt+1 反之 cnt-1
            cnt = array[i] == majority ? cnt + 1 : cnt - 1;
            //如果cnt > 0 说明之前的元素中 majority 多于 i/2
            if (cnt == 0) {
                //重置
                majority = array[i];//最多元素设为当前数组元素
                cnt = 1;//计数器重置
            }
        }
        int cnt = 0;//计数器
        for (int val : array) {
            if (val == majority) {
                cnt++;//计数+1
            }
        }
        return cnt > array.length / 2 ? majority : 0; //计数器大于数组长度一半返回做多元素反之返回0
    }
}