package com.hchenpan;

import org.junit.Test;

/**
 * Project : Sword2Offer
 * ClassName : com.hchenpan.b33_丑数
 * Description :
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数。
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/8 下午 11:26
 **/
public class b33_丑数 {
    @Test
    public void test() {
        System.out.println(GetUglyNumber_Solution(1)); // 1
        System.out.println(GetUglyNumber_Solution(2)); // 2
        System.out.println(GetUglyNumber_Solution(3)); // 3
        System.out.println(GetUglyNumber_Solution(4)); // 4
        System.out.println(GetUglyNumber_Solution(5)); // 5
        System.out.println(GetUglyNumber_Solution(6)); // 6
        System.out.println(GetUglyNumber_Solution(7)); // 8
        System.out.println(GetUglyNumber_Solution(8)); // 9
        System.out.println(GetUglyNumber_Solution(9)); // 10
        System.out.println(GetUglyNumber_Solution(10)); // 12
        System.out.println(GetUglyNumber_Solution(11)); // 15
        System.out.println(GetUglyNumber_Solution(1500)); // 859963392
        System.out.println(GetUglyNumber_Solution(0)); // 0
    }

    public int GetUglyNumber_Solution(int index) {
        if (index <= 6) {
            //比6小的都是丑数，选最大的返回
            return index;
        }
        int i2 = 0, i3 = 0, i5 = 0;
        int[] dp = new int[index];
        dp[0] = 1;
        for (int i = 1; i < index; i++) {
            int next2 = dp[i2] * 2, next3 = dp[i3] * 3, next5 = dp[i5] * 5;//推测下一个数 2 3 5 的倍数
            dp[i] = Math.min(next2, Math.min(next3, next5));//取最小的
            if (dp[i] == next2) {
                //2的倍数 2次数+1
                i2++;
            }
            if (dp[i] == next3) {
                //3的倍数 3次数+1
                i3++;
            }
            if (dp[i] == next5) {
                //5的倍数 5次数+1
                i5++;
            }
        }
        return dp[index - 1];
    }
}