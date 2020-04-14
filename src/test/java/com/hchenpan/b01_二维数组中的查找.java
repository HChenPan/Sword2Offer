package com.hchenpan;


import org.junit.Test;

/**
 * Project : CodingInterviews
 * ClassName : com.hchenpan.二维数组中的查找
 * Description :
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/3/29 下午 08:56
 **/
public class b01_二维数组中的查找 {
    @Test
    public void test() {
        int[][] array = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print("\t" + anInt + ",");
            }
            System.out.println();
        }
        System.out.println(Find(6, array));
    }

    /**
     * description(描述) 二维数组查找
     *
     * @param target 查找目标
     * @param array  二维数组
     * @return boolean
     * @author Huangcp
     * @date 2020/3/29 下午 08:58
     **/
    public boolean Find(int target, int[][] array) {
        //查找结果
        boolean found = false;
        //二维数组列长度
        int lie = array[0].length;
        //二维数组行长度
        int hang = array.length;
        //列最后坐标
        int column = lie - 1;
        //行初始坐标
        int row = 0;
        //递进比较各行最后一个
        while (row < hang && column >= 0) {
            int value = array[row][column];
            if (target > value) {
                //行数+1
                row++;
            } else if (value > target) {
                //列数-1
                column--;
            } else {
                //查找到退出循环
                found = true;
                break;
            }
        }
        return found;
    }
}