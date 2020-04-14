package com.hchenpan;

import org.junit.Test;

/**
 * Project : SwordOffer
 * ClassName : com.hchenpan.b10_矩形覆盖
 * Description :
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 比如n=3时，2*3的矩形块有3种覆盖方法
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/3/31 下午 11:17
 **/
public class b10_矩形覆盖 {
    @Test
    public void test() {
        System.out.println(RectCover(3));
    }

    public int RectCover(int target) {
        if (target < 1) {
            return 0;
        } else if (target == 1 || target == 2) {
            return target;
        } else {
            return RectCover(target - 1) + RectCover(target - 2);
        }
    }
}