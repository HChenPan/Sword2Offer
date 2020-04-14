package com.hchenpan;

import org.junit.Test;

/**
 * Project : Sword2Offer
 * ClassName : com.hchenpan.b48_不用加减乘除做加法
 * Description : 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/10 下午 05:05
 **/
public class b48_不用加减乘除做加法 {
    @Test
    public void test() {
        System.out.println(Add(5, 7));
    }

    public int Add(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1 ^ num2; //二进制每位相加就相当于各位做异或操作   不算进位
            num2 = (num1 & num2) << 1;//计算进位值，相当于各位做与操作，再向左移一位得到
            num1 = temp;
        }
        return num1;
    }
}