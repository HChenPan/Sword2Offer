package com.hchenpan;

import org.junit.Test;

/**
 * Project : Sword2Offer
 * ClassName : com.hchenpan.b37_数字在排序数组中出现的次数
 * Description : 统计一个数字在排序数组中出现的次数。
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/9 下午 08:43
 **/
public class b37_数字在排序数组中出现的次数 {
    @Test
    public void test() {
        // 查找的数字出现在数组的中间
        int[] data1 = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(GetNumberOfK(data1, 3)); // 4
        // 查找的数组出现在数组的开头
        int[] data2 = {3, 3, 3, 3, 4, 5};
        System.out.println(GetNumberOfK(data2, 3)); // 4
        // 查找的数组出现在数组的结尾
        int[] data3 = {1, 2, 3, 3, 3, 3};
        System.out.println(GetNumberOfK(data3, 3)); // 4
        // 查找的数字不存在
        int[] data4 = {1, 3, 3, 3, 3, 4, 5};
        System.out.println(GetNumberOfK(data4, 2)); // 0
        // 查找的数字比第一个数字还小，不存在
        int[] data5 = {1, 3, 3, 3, 3, 4, 5};
        System.out.println(GetNumberOfK(data5, 0)); // 0
        // 查找的数字比最后一个数字还大，不存在
        int[] data6 = {1, 3, 3, 3, 3, 4, 5};
        System.out.println(GetNumberOfK(data6, 0)); // 0
        // 数组中的数字从头到尾都是查找的数字
        int[] data7 = {3, 3, 3, 3};
        System.out.println(GetNumberOfK(data7, 3)); // 4
        // 数组中的数字从头到尾只有一个重复的数字，不是查找的数字
        int[] data8 = {3, 3, 3, 3};
        System.out.println(GetNumberOfK(data8, 4)); // 0
        // 数组中只有一个数字，是查找的数字
        int[] data9 = {3};
        System.out.println(GetNumberOfK(data9, 3)); // 1
        // 数组中只有一个数字，不是查找的数字
        int[] data10 = {3};
        System.out.println(GetNumberOfK(data10, 4)); // 0
        int[] data11 = {1, 2, 3, 3, 3, 3, 5, 9};
        System.out.println(GetNumberOfK(data1, 3)); // 4

    }

    public int GetNumberOfK(int[] array, int k) {
        int first = binarySearch(array, k);//查找 k 的起始坐标
        int last = binarySearch(array, k + 1);//查找比 k大且相邻的起始坐标
        return (first == array.length || array[first] != k) ? 0 : last - first;//若k不存在数组中返回0
    }

    private int binarySearch(int[] array, int K) {
        int low = 0;
        int height = array.length;
        while (low < height) {
            //二分查找
            int m = low + (height - low) / 2;
            if (array[m] >= K) {
                height = m;
            } else {
                low = m + 1;
            }
        }
        return low;
    }
}