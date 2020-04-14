package com.hchenpan;

import org.junit.Test;

import java.util.Arrays;

/**
 * Project : SwordOffer
 * ClassName : com.hchenpan.b13_调整数组顺序使奇数位于偶数前面
 * Description :
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/1 下午 10:11
 **/
public class b13_调整数组顺序使奇数位于偶数前面 {
    @Test
    public void test() {
        int[] arr = {1, 2, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));
        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void reOrderArray(int[] array) {
        if (array.length > 1) {
            for (int i = 0; i < array.length; i++) {
                int j = i + 1;
                if (array[i] % 2 == 0) {
                    // a[i]为偶数，j前进，直到a[j]为奇数替换
                    while (array[j] % 2 == 0) {
                        if (j == array.length - 1) {
                            //a[i]为偶数，a[j]也为偶数，一直后移到了末尾，证明i->j后面都是偶数
                            return;
                        }
                        // a[j]为偶数，j++
                        j++;
                    }
                    //a[j]为奇数 交换
                    //eg: 2465
                    int temp = array[j];
                    //1 i->j 之间平移
                    while (i < j) {
                        array[j] = array[--j];
                    }
                    //2 交换a[i]
                    array[i] = temp;
                }
            }
        }
    }
}