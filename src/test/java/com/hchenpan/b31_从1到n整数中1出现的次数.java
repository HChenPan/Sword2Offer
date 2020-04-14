package com.hchenpan;

import org.junit.Test;

/**
 * Project : SwordOffer
 * ClassName : com.hchenpan.b31_从1到n整数中1出现的次数
 * Description :
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/7 上午 01:21
 **/
public class b31_从1到n整数中1出现的次数 {
    @Test
    public void test() {
        System.out.println(NumberOf1Between1AndN_Solution(1)); // 1
        System.out.println(NumberOf1Between1AndN_Solution(5)); // 1
        System.out.println(NumberOf1Between1AndN_Solution(10)); // 2
        System.out.println(NumberOf1Between1AndN_Solution(55)); // 16
        System.out.println(NumberOf1Between1AndN_Solution(99)); // 20
        System.out.println(NumberOf1Between1AndN_Solution(10000)); // 4001
        System.out.println(NumberOf1Between1AndN_Solution(21345)); // 18821
        System.out.println(NumberOf1Between1AndN_Solution(54687)); //32439
        System.out.println(NumberOf1Between1AndN_Solution(0)); // 0
        System.out.println(NumberOf1Between1AndN_Solution(-1));
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {
            int a = n / i;//取第 i 位左边（高位）的数字，乘以 10的i−1次方，得到基础值 a
            int b = n % i;//取第 i 位数字，计算修正值
            //如果大于 1，则结果为 a+10的i−1次方。
            //如果小于 1，则结果为 a。
            //如果等于 1，则取第 i 位右边（低位）数字，设为 b，最后结果为 a+b+1
            count +=
                    (a + 8) / 10 * i
                            + (a % 10 == 1 ? b + 1 : 0);
        }
        return count;
    }
}