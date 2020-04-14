package com.hchenpan;

import org.junit.Test;

/**
 * Project : Sword2Offer
 * ClassName : com.hchenpan.b67_机器人的运动范围
 * Description :
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/11 下午 04:40
 **/
public class b67_机器人的运动范围 {
    @Test
    public void test() {

    }

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] flag = new boolean[rows][cols];
        return helper(0, 0, rows, cols, flag, threshold);
    }

    public int helper(int i, int j, int rows, int cols, boolean[][] flag, int threshold) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || flag[i][j] || numSum(i) + numSum(j) > threshold)
            return 0;
        flag[i][j] = true;
        return helper(i - 1, j, rows, cols, flag, threshold) +
                helper(i + 1, j, rows, cols, flag, threshold) +
                helper(i, j - 1, rows, cols, flag, threshold) +
                helper(i, j + 1, rows, cols, flag, threshold) + 1;
    }

    public int numSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}