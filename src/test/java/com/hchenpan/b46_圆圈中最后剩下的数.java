package com.hchenpan;

import org.junit.Test;

/**
 * Project : Sword2Offer
 * ClassName : com.hchenpan.b46_圆圈中最后剩下的数
 * Description :
 * 让小朋友们围成一个大圈。然后，随机指定一个数 m，
 * 让编号为 0 的小朋友开始报数。每次喊到 m-1 的那个小朋友要出列唱首歌，
 * 然后可以在礼品箱中任意的挑选礼物，并且不再回到圈中，从他的下一个小朋友开始，
 * 继续 0...m-1 报数 .... 这样下去 ....
 * 直到剩下最后一个小朋友，可以不用表演
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/10 下午 03:46
 **/
public class b46_圆圈中最后剩下的数 {
    @Test
    public void test() {
        System.out.println(LastRemaining_Solution(5, 3)); // 最后余下3
        System.out.println(LastRemaining_Solution(5, 2)); // 最后余下2
        System.out.println(LastRemaining_Solution(6, 7)); // 最后余下4
        System.out.println(LastRemaining_Solution(6, 6)); // 最后余下3
        System.out.println(LastRemaining_Solution(0, 0)); // 最后余下-1
    }

    public int LastRemaining_Solution(int n, int m) {
        if (n == 0) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            //模拟存在 i 个人时 last 为最后胜利者
            last = (last + m) % i;//模拟报数，防止内存溢出取余数
        }
        return last;
    }
}