package com.hchenpan;

import org.junit.Test;

/**
 * Project : Sword2Offer
 * ClassName : com.hchenpan.b49_把字符串转换成整数
 * Description : 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * Iuput:
 * +2147483647
 * 1a33
 * Output:
 * 2147483647
 * 0
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/10 下午 09:47
 **/
public class b49_把字符串转换成整数 {
    @Test
    public void test() {
        System.out.println(Integer.parseInt(Integer.MIN_VALUE + ""));
        System.out.println(0x8000_0000L);
        System.out.println(StrToInt(""));
        System.out.println(StrToInt("123"));
        System.out.println(StrToInt("+123"));
        System.out.println(StrToInt("-123"));
        System.out.println(StrToInt("1a123"));
        System.out.println(StrToInt("+2147483647"));
        System.out.println(StrToInt("-2147483647"));
        System.out.println(StrToInt("+2147483648"));
        System.out.println(StrToInt("-2147483648"));
        System.out.println(StrToInt("+2147483649"));
        System.out.println(StrToInt("-2147483649"));
        System.out.println(StrToInt("+"));
        System.out.println(StrToInt("-"));
    }

    public int StrToInt(String str) {
        if (str == null) {
            return 0;
        }
        int result = 0;
        boolean negative = false;//是否负数
        int i = 0;
        int len = str.length();
        /*
         * limit 默认初始化为*负的*最大正整数 ，假如字符串表示的是正数
         * 由于int的范围为-2147483648~2147483647
         * 那么result(在返回之前一直是负数形式)就必须和这个最大正数的负数来比较来判断是否溢出，
         */
        int limit = -Integer.MAX_VALUE;//-2147483647
        int multmin;
        int digit;
        if (len > 0) {
            char firstChar = str.charAt(0);//首先看第一位
            if (firstChar < '0') {
                // 有可能是 "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    //在负号的情况下，判断溢出的值就变成了 整数的 最小负数了
                    limit = Integer.MIN_VALUE;//-2147483648
                } else if (firstChar != '+') {//第一位不是数字和-只能是+
                    return 0;
                }
                // 不能单独 "+" or "-"
                if (len == 1) {
                    return 0;
                }
                i++;
            }
            multmin = limit / 10;
            while (i < len) {
                digit = str.charAt(i++) - '0';//计算ASCII差值值
                if (digit < 0 || digit > 9) {
                    return 0;
                }
                //判断溢出
                if (result < multmin) {
                    return 0;
                }
                result *= 10;
                if (result < limit + digit) {
                    return 0;
                }
                result -= digit;
            }
        } else {
            return 0;
        }
        //如果是正数就返回-result（result一直是负数）
        return negative ? result : -result;
    }
}