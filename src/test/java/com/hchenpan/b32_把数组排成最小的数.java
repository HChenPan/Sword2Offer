package com.hchenpan;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Project : Sword2Offer
 * ClassName : com.hchenpan.b32_把数组排成最小的数
 * Description :
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/8 下午 11:10
 **/
public class b32_把数组排成最小的数 {
    @Test
    public void test() {
        int[] data = {3, 5, 1, 4, 2};
        System.out.println(PrintMinNumber(data));
        int[] data2 = {3, 32, 321};
        System.out.println(PrintMinNumber(data2));
        int[] data3 = {3, 323, 32123};
        System.out.println(PrintMinNumber(data3));
        int[] data4 = {1, 11, 111};
        System.out.println(PrintMinNumber(data4));
        int[] data5 = {321};
        System.out.println(PrintMinNumber(data5));
    }

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        int n = numbers.length;
        String[] nums = new String[n];
        for (int i = 0; i < n; i++) {
            nums[i] = numbers[i] + "";
        }
        Arrays.sort(nums, new Comparator<String>() {
            // 自定义排序  比较的 S1+S2 和 S2+S1 的大小 取小的
            @Override
            public int compare(String s1, String s2) {
                return (s1 + s2).compareTo(s2 + s1);
            }
        });//排序结果 nums 中都是从小到大的组合
        StringBuilder ret = new StringBuilder();
        for (String str : nums) {
            ret.append(str);
        }
        return ret.toString();
    }
}