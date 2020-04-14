package com.hchenpan;

import org.junit.Test;

/**
 * Project : SwordOffer
 * ClassName : com.hchenpan.b11_二进制中1的个数
 * Description :   输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/1 上午 12:09
 **/
public class b11_二进制中1的个数 {
    @Test
    public void test() {
        int num = 0B00000000_00000000_00000000_00000000;    // 0
        System.out.println(NumberOf1(num));
        num = 0B00000000_00000000_00000000_00000001;    // 1
        System.out.println(NumberOf1(num));
        num = 0B11111111_11111111_11111111_11111111;    // -1
        System.out.println(NumberOf1(num));
        num = 0B01111111_11111111_11111111_11111111;    // Integer.MAX_VALUE
        System.out.println(NumberOf1(num));
        num = 0B10000000_00000000_00000000_00000000;    // Integer.MIN_VALUE
        System.out.println(NumberOf1(num));
        num = 3;
        System.out.println(NumberOf1(num));
    }

    /**
     * 一个数减去1：（如果一个数不是0，那么它的二进制中至少有1位是1）
     * - 假设这个数的最后一位是1，那么减去1之后，只是最后一位由1变成了0，其他位不变。
     * - 最后一位不是1，假设这个数第m位是1，减去1之后，第m位由1变成了0，m后面的0全部变成了1，m前面的数字不变
     * 这时 n & (n-1)，就可以把m后面的那些1右变回了0，然后再继续 判断、减1     两个同时为1，结果为1，否则为0
     */
    public int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            n = n & (n - 1);
            cnt++;      //所以cnt就记录着 n一共被减了多少次1，即n的二进制表示中1的个数
        }
        return cnt;
    }
}