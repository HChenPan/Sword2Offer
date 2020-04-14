package com.hchenpan;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Project : Sword2Offer
 * ClassName : com.hchenpan.b42_和为S的两个数字
 * Description :输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/10 上午 01:18
 **/
public class b42_和为S的两个数字 {
    @Test
    public void test() {
        int[] data1 = {1, 2, 4, 7, 11, 15};
        System.out.println(FindNumbersWithSum(data1, 15));
        int[] data2 = {1, 2, 4, 7, 11, 16};
        System.out.println(FindNumbersWithSum(data2, 17));
        int[] data3 = {1, 2, 4, 7, 11, 16};
        System.out.println(FindNumbersWithSum(data3, 10));
    }

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        //array 是递增数组
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            int cur = array[i] + array[j];//当前两数 和
            if (cur == sum) {
                //因为两个数向中间靠拢，首次满足必定是乘积最小
                return new ArrayList<>(Arrays.asList(array[i], array[j]));
            }
            if (cur < sum) {
                //和小于目标值 小数增大
                i++;
            } else {
                //和大于目标值 大数减小
                j--;
            }
        }
        return new ArrayList<>();
    }
}