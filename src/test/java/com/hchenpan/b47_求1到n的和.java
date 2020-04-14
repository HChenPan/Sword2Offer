package com.hchenpan;

import org.junit.Test;

/**
 * Project : Sword2Offer
 * ClassName : com.hchenpan.b47_求1到n的和
 * Description :   要求不能使用乘除法、for、while、if、else、switch、case 等关键字及条件判断语句 A ? B : C
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/10 下午 04:29
 **/
public class b47_求1到n的和 {
    @Test
    public void test() {
        System.out.println(Sum_Solution(5));
    }

    public int Sum_Solution(int n) {
        return ((int) (Math.pow(n, 2) + n)) >> 1;
    }
}