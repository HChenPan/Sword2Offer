package com.hchenpan;

import org.junit.Test;

/**
 * Project : SwordOffer
 * ClassName : com.hchenpan.b08_变态跳台阶
 * Description :
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/3/31 下午 11:17
 **/
public class b09_变态跳台阶 {
    @Test
    public void test() {
        System.out.println(JumpFloor(1));
    }

    public int JumpFloor(int target) {
        //2的（n-1）次方
        return 1 << (target - 1);
    }
}