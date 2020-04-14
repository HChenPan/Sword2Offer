package com.hchenpan;

import org.junit.Test;

/**
 * Project : SwordOffer
 * ClassName : com.hchenpan.b08_跳台阶
 * Description :
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/3/31 下午 11:17
 **/
public class b08_跳台阶 {
    @Test
    public void test() {
        System.out.println(JumpFloor(1));
    }

    public int JumpFloor(int target) {
        int a = 1; //一阶数目
        int b = 1; //二阶数目
        for (int i = 1; i < target; i++) {
            //层数在一层以上
            a = a + b;//跳到本层=一阶数目+二阶数目
            b = a - b;//本层之前的二阶数目=本层数目-本层之前二阶数目
        }
        return a;
    }
}