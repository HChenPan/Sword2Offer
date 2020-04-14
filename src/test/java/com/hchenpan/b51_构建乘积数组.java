package com.hchenpan;

import org.junit.Test;

import java.util.Arrays;

/**
 * Project : Sword2Offer
 * ClassName : com.hchenpan.b51_构建乘积数组
 * Description : b[i] 去除a[i]之后所有元素乘积
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/10 下午 10:46
 **/
public class b51_构建乘积数组 {
    @Test
    public void test() {
        int[] array1 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(multiply(array1))); // int expected[] = {120, 60, 40, 30, 24};
        int[] array2 = {1, 2, 0, 4, 5};
        System.out.println(Arrays.toString(multiply(array2))); // int expected[] = {0, 0, 40, 0, 0};
        int[] array3 = {1, 2, 0, 4, 0};
        System.out.println(Arrays.toString(multiply(array3))); // int expected[] = {0, 0, 0, 0, 0};
        int[] array4 = {1, -2, 3, -4, 5};
        System.out.println(Arrays.toString(multiply(array4))); // int expected[] = {120, -60, 40, -30, 24};
        int[] array5 = {1, -2};
        System.out.println(Arrays.toString(multiply(array5))); // int expected[] = {-2, 1};

    }

    public int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        for (int i = 0, product = 1; i < n; product *= A[i], i++) {
            /*
             *从左往右累乘
             *结果是 b[i]=a[0]***a[i]
             */
            B[i] = product;
        }
        for (int j = n - 1, product = 1; j >= 0; product *= A[j], j--) {
            /*
             *从右往左累乘
             * 结果是 b[j]=a[0]***a[j]***a[j]
             */
            B[j] *= product;
        }
        return B;
    }
}