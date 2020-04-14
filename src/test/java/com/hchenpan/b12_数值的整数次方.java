package com.hchenpan;

import org.junit.Test;

/**
 * Project : SwordOffer
 * ClassName : com.hchenpan.b12_数值的整数次方
 * Description :
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/1 上午 12:45
 **/
public class b12_数值的整数次方 {
    @Test
    public void test() {
        System.out.println(0.0000000000000000000000001111 == 0);
        System.out.println(0.0000000000000000000000000000 == 0);

        System.out.println(Power(3,6));
        System.out.println(Power(2, -4));
        System.out.println(Power(2, 4));
        System.out.println(Power(2, 0));
        System.out.println(Power(0.00000000000000000000000000001, 1));
        System.out.println(Power(0.00000000000000000000000000001, -1));
        System.out.println(Power(0.00000000000000000000000000001, 0));
        System.out.println(Power(0.00000000000000000000000000000, 0));
    }

    public double Power(double base, int exponent) {
        if (base == 0.0) {
            return 0.0;
        }
        // 前置结果设为1.0，即当exponent=0 的时候，就是这个结果
        double result = 1.0d;
        // 获取指数的绝对值
        int e = exponent > 0 ? exponent : -exponent;
        // 根据指数大小，循环累乘
        for (int i = 1; i <= e; i++) {
            result *= base;
        }
        // 根据指数正负，返回结果
        return exponent > 0 ? result : 1 / result;
    }
}