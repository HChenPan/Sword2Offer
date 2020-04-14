package com.hchenpan;

import org.junit.Test;

/**
 * Project : CodingInterviews
 * ClassName : com.hchenpan.替换空格
 * Description :
 * 请实现一个函数，将一个字符串中的每个空格替换成 “%20”。
 * 例如，当字符串为 We Are Happy.则经过替换之后的字符串为 We%20Are%20Happy。
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/3/29 下午 09:31
 **/
public class b02_替换空格 {
    @Test
    public void test() {
        System.out.println(replaceSpace(new StringBuffer().append("We   Are Happy")));
    }

    public String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        //暂存
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            //遍历str元素
            if (str.charAt(i) == ' ') {
                //替换空格
                newStr.append("%20");
            } else {
                //复制
                newStr.append(str.charAt(i));
            }
        }
        return String.valueOf(newStr);
    }
}