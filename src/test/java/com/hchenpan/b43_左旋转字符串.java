package com.hchenpan;

import org.junit.Test;

/**
 * Project : Sword2Offer
 * ClassName : com.hchenpan.b43_左旋转字符串
 * Description :汇编语言中有一种移位指令叫做循环左移（ROL），
 * 现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,
 * 要求输出循环左移3位后的结果，即“XYZdefabc”
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/10 上午 01:26
 **/
public class b43_左旋转字符串 {
    @Test
    public void test() {
        System.out.println(LeftRotateString("abcdefg", 2));
        System.out.println(LeftRotateString("abcdefg", 1));
        System.out.println(LeftRotateString("abcdefg", 6));
        System.out.println(LeftRotateString("abcdefg", 17));
        System.out.println(LeftRotateString("abcdefg", 0));
    }

    public String LeftRotateString(String str, int n) {
        if (str.length() == 0 || n < 0) {
            return "";
        }
        //修正 n 防止内存溢出
        n = n % str.length();
        return str.substring(n) + str.substring(0, n);
    }


}