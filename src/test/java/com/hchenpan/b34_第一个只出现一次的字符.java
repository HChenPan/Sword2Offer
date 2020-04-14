package com.hchenpan;

import org.junit.Test;

import java.util.BitSet;

/**
 * Project : Sword2Offer
 * ClassName : com.hchenpan.b34_第一个只出现一次的字符
 * Description :
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1 需要区分大小写
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/9 上午 01:04
 **/
public class b34_第一个只出现一次的字符 {
    @Test
    public void test() {
        System.out.println(FirstNotRepeatingChar("google")); // l
        System.out.println(FirstNotRepeatingChar("aabccdbd")); // '\0'
        System.out.println(FirstNotRepeatingChar("abcdefg")); // a
        System.out.println(FirstNotRepeatingChar("gfedcba")); // g
        System.out.println(FirstNotRepeatingChar("zgfedcbaz")); // z
    }

    public int FirstNotRepeatingChar(String str) {
        BitSet bs1 = new BitSet(256);
        BitSet bs2 = new BitSet(256);
        for (char c : str.toCharArray()) {
            if (!bs1.get(c) && !bs2.get(c)) {
                // 1 2 集合中都不存在的字符 放入 1集合
                bs1.set(c);     // 0 0 -> 0 1
            } else if (bs1.get(c) && !bs2.get(c)) {
                //1集合存在 2集合不存在 放入2集合
                bs2.set(c);     // 0 1 -> 1 1
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);       //顺序遍历字符串
            if (bs1.get(c) && !bs2.get(c)) {
                //存在1号集合 但不存在2号集合
                // 0 1
                return i;
            }
        }
        return -1;
    }
}
