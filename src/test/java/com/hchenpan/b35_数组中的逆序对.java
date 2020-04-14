package com.hchenpan;

import org.junit.Test;

/**
 * Project : Sword2Offer
 * ClassName : com.hchenpan.b35_数组中的逆序对
 * Description :
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 输入 1,2,3,4,5,6,7,0
 * 输出 7
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/9 下午 02:13
 **/
public class b35_数组中的逆序对 {
    @Test
    public void test() {
        int[] data = {1, 2, 3, 4, 7, 6, 5};
        System.out.println(InversePairs(data)); // 3
        int[] data2 = {6, 5, 4, 3, 2, 1};
        System.out.println(InversePairs(data2)); //  15
        int[] data3 = {1, 2, 3, 4, 5, 6};
        System.out.println(InversePairs(data3)); // 0
        int[] data4 = {1};
        System.out.println(InversePairs(data4)); // 0
        int[] data5 = {1, 2};
        System.out.println(InversePairs(data5)); // 0
        int[] data6 = {2, 1};
        System.out.println(InversePairs(data6)); // 1
        int[] data7 = {1, 2, 1, 2, 1};
        System.out.println(InversePairs(data7)); // 3
    }

    private int[] aux;
    private int count;

    public int InversePairs(int[] array) {
        count = 0;
        //input check
        if (array.length < 1) {
            return -1;
        }
        //execute
        //使用归并排序的思想: 先拆分,再排序. 在比较元素大小的时候统计逆序对的总数
        //要不要使用一个全局变量计数?
        aux = new int[array.length];
        MergeCore(array, 0, array.length - 1);
        return count % 1000000007;
    }

    public void MergeCore(int[] array, int lo, int hi) {
        // 每次递归的作用: 合并左右两个有序的数组
        //recursion finish
        //if(lo==hi)
        //    return;
        if (lo != hi) {
            int mid = (lo + hi) >> 1;
            MergeCore(array, lo, mid);
            MergeCore(array, mid + 1, hi);
            Merge(array, lo, mid, hi);
        }
    }

    public void Merge(int[] a, int lo, int mid, int hi) {
        int i = mid, j = hi;
        if (hi + 1 - lo >= 0) {
            System.arraycopy(a, lo, aux, lo, hi + 1 - lo);
        }
        for (int k = hi; k >= lo; k--) {
            if (i < lo) {           // 前半部分的所有元素都比后半部分大
                a[k] = aux[j--];
            } else if (j < mid + 1) {// 后半部分的所有元素都比前半部分大
                a[k] = aux[i--];
            } else if (aux[i] <= aux[j]) {
                a[k] = aux[j--];
            } else { // aux[i] > aux[j]
                a[k] = aux[i--];
                count = count + j - mid;
                if (count > 1000000007) {
                    count = count % 1000000007;
                }
            }
        }
    }
}