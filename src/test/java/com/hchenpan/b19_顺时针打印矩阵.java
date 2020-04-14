package com.hchenpan;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Project : SwordOffer
 * ClassName : com.hchenpan.b19_顺时针打印矩阵
 * Description :
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵：
 * 1  2  3  4
 * 5  6  7  8
 * 9 10 11 12
 * 13 14 15 16
 * 则依次打印出数字
 * 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/2 下午 11:11
 **/
public class b19_顺时针打印矩阵 {
    @Test
    public void test() {
        int[][] numbers = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9},
        };

        for (Integer integer : printMatrix(numbers)) {
            System.out.print(integer);
        }
    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix[0].length == 0 || matrix.length == 0) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int 上坐标 = 0;
        int 左坐标 = 0;
        int 右坐标 = matrix[0].length - 1;
        int 下坐标 = matrix.length - 1;
        while (左坐标 <= 右坐标 && 上坐标 <= 下坐标) {
            for (int i = 左坐标; i <= 右坐标; i++) {
                list.add(matrix[上坐标][i]);
            }
            for (int i = 上坐标 + 1; i <= 下坐标; i++) {
                list.add(matrix[i][右坐标]);
            }
            if (上坐标 != 下坐标) {
                for (int i = 右坐标 - 1; i >= 左坐标; i--) {
                    list.add(matrix[下坐标][i]);
                }
            }
            if (左坐标 != 右坐标) {
                for (int i = 下坐标 - 1; i > 上坐标; i--) {
                    list.add(matrix[i][左坐标]);
                }
            }
            上坐标++;
            左坐标++;
            右坐标--;
            下坐标--;
        }
        return list;
    }
}