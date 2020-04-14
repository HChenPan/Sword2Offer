package com.hchenpan;

import org.junit.Test;

/**
 * Project : SwordOffer
 * ClassName : com.hchenpan.b07_斐波那契数列
 * Description :
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/3/31 下午 10:39
 **/
public class b07_斐波那契数列 {

    @Test
    public void test() {
        System.out.println(Fibonacci(10));
    }

    public int Fibonacci(int n) {
        return n < 2 ?
                (n < 1 ?
                        0 : 1) :
                Fibonacci(n - 1) + Fibonacci(n - 2);
    }

}