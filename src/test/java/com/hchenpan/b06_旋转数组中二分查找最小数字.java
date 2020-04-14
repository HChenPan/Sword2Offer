package com.hchenpan;

import org.junit.Test;

/**
 * Project : SwordOffer
 * ClassName : com.hchenpan.b06_旋转数组中二分查找最小数字
 * Description :
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/3/31 下午 05:00
 **/
public class b06_旋转数组中二分查找最小数字 {
    @Test
    public void test() {
        // 典型输入，单调升序的数组的一个旋转
        int[] array1 = {3, 4, 5, 1, 2};
        System.out.println(minNumberInRotateArray(array1));
        System.out.println("---"+1);
        // 有重复数字，并且重复的数字刚好的最小的数字
        int[] array2 = {3, 4, 5, 1, 1, 2};
        System.out.println(minNumberInRotateArray(array2));
        System.out.println("---"+1);
        // 有重复数字，但重复的数字不是第一个数字和最后一个数字
        int[] array3 = {3, 4, 5, 1, 2, 2};
        System.out.println(minNumberInRotateArray(array3));
        System.out.println("---"+1);
        // 有重复的数字，并且重复的数字刚好是第一个数字和最后一个数字
        int[] array4 = {1, 0, 1, 1, 1};
        System.out.println(minNumberInRotateArray(array4));
        System.out.println("---"+0);
        // 单调升序数组，旋转0个元素，也就是单调升序数组本身
        int[] array5 = {1, 2, 3, 4, 5};
        System.out.println(minNumberInRotateArray(array5));
        System.out.println("---"+1);
        // 数组中只有一个数字
        int[] array6 = {2};
        System.out.println(minNumberInRotateArray(array6));
        System.out.println("---"+2);
        // 数组中数字都相同
        int[] array7 = {1, 1, 1, 1, 1, 1, 1};
        System.out.println(minNumberInRotateArray(array7));
        System.out.println("---"+1);
        // 输入NULL
        System.out.println(minNumberInRotateArray(null));
    }

    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2; //二分
            if (array[mid] > array[high]) {
                //中间大于高位 低位移动到中间前一位
                low = mid + 1;
            } else if (array[mid] == array[high]) {
                //中间等于高位 高位向后一位
                high = high - 1;
            } else if (array[mid] < array[high]) {
                //中间小于高位 高位移动到中间位
                high = mid;
            }
        }
        return array[low];
    }
}