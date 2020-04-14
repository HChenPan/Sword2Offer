package com.hchenpan;

import org.junit.Test;

/**
 * Project : Sword2Offer
 * ClassName : com.hchenpan.b44_翻转单词顺序列
 * Description :
 * Input:
 * "I am a student."
 * Output:
 * "student. a am I"
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/10 上午 01:36
 **/
public class b44_翻转单词顺序列 {
    @Test
    public void test() {
        System.out.println(ReverseSentence("I am a student."));
        System.out.println(ReverseSentence("Wonderful"));
        System.out.println(ReverseSentence(""));
        System.out.println(ReverseSentence("    "));
    }

    public String ReverseSentence(String str) {
        if ("".equals(str.trim())) {
            return str;
        }
        String[] word = str.split(" ");//分离出单词
        StringBuilder sb = new StringBuilder();
        for (int i = word.length - 1; i >= 0; i--) {
            //逆序遍历单词数组
            sb.append(word[i]).append(" ");
        }
        return sb.toString().trim();
    }
}