package com.hchenpan;

import org.junit.Test;

/**
 * Project : Sword2Offer
 * ClassName : com.hchenpan.b50_数组中重复的数字
 * Description :
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出是第一个重复的数字2
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/10 下午 10:11
 **/
public class b50_数组中重复的数字 {
    @Test
    public void test() {
        int[] numbers = {2, 3, 1, 4, 5, 1, 3};
        int[] multi = {0};
        boolean duplicate;
        duplicate = duplicate(numbers, numbers.length, multi);
        if (duplicate) {
            System.out.println(multi[0]);
        }
        int[] numbers1 = {2, 1, 3, 1, 4};
        duplicate = duplicate(numbers1, numbers1.length, multi);
        if (duplicate) {
            System.out.println(multi[0]);
        }
        int[] numbers2 = {2, 4, 3, 1, 4};
        duplicate = duplicate(numbers2, numbers2.length, multi);
        if (duplicate) {
            System.out.println(multi[0]);
        }
    }

    /**
     * @param numbers     an array of integers
     * @param length      the length of array numbers
     * @param duplication (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
     * @return boolean        true if the input is valid, and there are some duplications in the array number otherwise false
     * @author Huangcp
     * @date 2020/4/10 下午 10:13
     **/
    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        if (length <= 1) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }
}