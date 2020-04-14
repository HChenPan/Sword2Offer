package com.hchenpan;

import org.junit.Test;

import java.util.Arrays;

/**
 * Project : Sword2Offer
 * ClassName : com.hchenpan.b45_扑克牌顺子
 * Description : 大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/10 下午 03:11
 **/
public class b45_扑克牌顺子 {
    @Test
    public void test() {
        int[] numbers1 = {1, 3, 2, 5, 4};
        System.out.println(isContinuous(numbers1));
        int[] numbers2 = {1, 3, 2, 6, 4};
        System.out.println(isContinuous(numbers2));
        int[] numbers3 = {0, 3, 2, 6, 4};
        System.out.println(isContinuous(numbers3));
        int[] numbers4 = {0, 3, 1, 6, 4};
        System.out.println(isContinuous(numbers4));
        int[] numbers5 = {1, 3, 0, 5, 0};
        System.out.println(isContinuous(numbers5));
        int[] numbers6 = {1, 3, 0, 7, 0};
        System.out.println(isContinuous(numbers6));
        int[] numbers7 = {1, 0, 0, 5, 0};
        System.out.println(isContinuous(numbers7));
        int[] numbers8 = {1, 0, 0, 7, 0};
        System.out.println(isContinuous(numbers8));
        int[] numbers9 = {3, 0, 0, 0, 0};
        System.out.println(isContinuous(numbers9));
        int[] numbers10 = {0, 0, 0, 0, 0};
        System.out.println(isContinuous(numbers10));
        int[] numbers11 = {1, 0, 0, 1, 0};
        System.out.println(isContinuous(numbers11));
    }

    public boolean isContinuous(int[] numbers) {
        if (numbers.length < 5) {
            return false;
        }
        Arrays.sort(numbers);
        // 统计癞子数量
        int cnt = 0;
        for (int num : numbers) {
            if (num == 0) {
                cnt++;
            }
        }
        // 使用癞子去补全不连续的顺子
        for (int i = cnt; i < numbers.length - 1; i++) {
            if (numbers[i + 1] == numbers[i]) {
                return false;
            }
            cnt -= numbers[i + 1] - numbers[i] - 1;//癞子补上不连续的位置
        }
        return cnt >= 0;
    }
}