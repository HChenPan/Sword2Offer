package com.hchenpan;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Project : Sword2Offer
 * ClassName : com.hchenpan.b41_和为S的连续正数序列
 * Description : 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/9 下午 11:49
 **/
public class b41_和为S的连续正数序列 {
    @Test
    public void test() {
        System.out.println(FindContinuousSequence(1));
        System.out.println(FindContinuousSequence(3));
        System.out.println(FindContinuousSequence(4));
        System.out.println(FindContinuousSequence(9));
        System.out.println(FindContinuousSequence(15));
        System.out.println(FindContinuousSequence(100));
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        int start = 1;//序列开始
        int end = 2;//序列结束
        int curSum = 3;//当前累加和
        while (end < sum) {
            //序列结束小于目标值
            if (curSum > sum) {
                curSum -= start;//累加和大于目标值 减去序列开始元素
                start++;//序列区间缩小
            } else if (curSum < sum) {
                end++;//序列区间扩张
                curSum += end;//累加和小于目标值 加上序列结束元素
            } else {
                //累加和等于目标值
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);//序列连续加入list
                }
                ret.add(list);
                //继续查找 重置
                curSum -= start;//累加和 减去开始元素
                start++;//开始元素后移
                end++;//开始元素后移
                curSum += end;//累加和 加上结束元素
            }
        }
        return ret;
    }
}