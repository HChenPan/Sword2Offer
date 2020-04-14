package com.hchenpan;

import org.junit.Test;

/**
 * Project : Sword2Offer
 * ClassName : com.hchenpan.b53_表示数值的字符串
 * Description :
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/10 下午 11:46
 **/
public class b53_表示数值的字符串 {
    @Test
    public void test() {
        System.out.println(isNumeric("100".toCharArray()) + "--true");
        System.out.println(isNumeric("123.45e+6".toCharArray()) + "--true");
        System.out.println(isNumeric("+500".toCharArray()) + "--true");
        System.out.println(isNumeric("5e2".toCharArray()) + "--true");
        System.out.println(isNumeric("3.1416".toCharArray()) + "--true");
        System.out.println(isNumeric("-.123".toCharArray()) + "--true");
        System.out.println(isNumeric("-1E-16".toCharArray()) + "--true");
        System.out.println(isNumeric("100".toCharArray()) + "--true");
        System.out.println(isNumeric("1.79769313486232E+308".toCharArray()) + "--true");
        System.out.println();
        System.out.println(isNumeric("12e".toCharArray()) + "--false");
        System.out.println(isNumeric("1a3.14".toCharArray()) + "--false");
        System.out.println(isNumeric("1+23".toCharArray()) + "--false");
        System.out.println(isNumeric("1.2.3".toCharArray()) + "--false");
        System.out.println(isNumeric("+-5".toCharArray()) + "--false");
        System.out.println(isNumeric("12e+5.4".toCharArray()) + "--false");
        System.out.println(isNumeric("600.".toCharArray()) + "--false");
    }

    public boolean isNumeric(char[] str) {
        /*
        []  ： 字符集合
        ()  ： 分组
        ?   ： 重复 0 ~ 1 次
        +   ： 重复 1 ~ n 次
        *   ： 重复 0 ~ n 次
        .   ： 任意字符
        \\. ： 转义后的 .
        \\d ： 数字
        */
        if (str == null || str.length == 0) {
            return false;
        }
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}