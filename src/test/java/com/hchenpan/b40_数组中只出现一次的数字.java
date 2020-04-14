package com.hchenpan;

import org.junit.Test;

import java.util.Arrays;

/**
 * Project : Sword2Offer
 * ClassName : com.hchenpan.b40_数组中只出现一次的数字
 * Description : 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/9 下午 11:19
 **/
public class b40_数组中只出现一次的数字 {
    @Test
    public void test() {
        int[] num1 = {0};
        int[] num2 = {0};
        int[] data1 = {2, 4, 3, 6, 3, 2, 5, 5};
        FindNumsAppearOnce(data1, num1, num2);
        System.out.println(num1[0] + " " + num2[0]);
        int[] data2 = {4, 6};
        FindNumsAppearOnce(data2, num1, num2);
        System.out.println(num1[0] + " " + num2[0]);
        int[] data3 = {4, 6, 1, 1, 1, 1};
        FindNumsAppearOnce(data3, num1, num2);
        System.out.println(num1[0] + " " + num2[0]);
    }

    /**
     * description(描述) num1,num2分别为长度为1的数组。传出参数 将num1[0],num2[0]设置为返回结果
     *
     * @author Huangcp
     * @date 2020/4/9 下午 11:20
     **/
    public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {
        // 排序
        Arrays.sort(array);

        // 然后遍历数组，判断前后不相等的元素
        boolean flag = true;    // 判断是第一个满足要求的数字
        for (int i = 0; i < array.length; i++) {
            if (i + 1 < array.length && array[i] == array[i + 1]) {
                i++;    // 跳过下一个数
            } else {
                if (flag) {
                    num1[0] = array[i];
                    flag = false;
                } else {
                    num2[0] = array[i];
                }
            }
        }

    }
}