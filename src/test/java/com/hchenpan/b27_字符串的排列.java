package com.hchenpan;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;

/**
 * Project : SwordOffer
 * ClassName : com.hchenpan.b27_字符串的排列
 * Description :
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串
 * abc,acb,bac,bca,cab和cba。
 *
 * @author Huangcp
 * @version 1.0
 * @date 2020/4/5 下午 05:39
 **/
public class b27_字符串的排列 {
    @Test
    public void test() {
        String str = new String();
        str = "abc";
        ArrayList<String> permutation = Permutation(str);
        for (String s : permutation) {
            System.out.println(s);
        }
    }

    public ArrayList<String> Permutation(String str) {
        TreeSet<String> tree = new TreeSet<>();//有序的集合
        Stack<String[]> stack = new Stack<>(); //字符栈
        //将字符串入栈
        stack.push(new String[]{str, ""});//将字符串入栈 字符串 空
        do {
            //栈顶元素出栈
            String[] popStrs = stack.pop();
            //字符数组中的第一个 后缀
            String statckStr = popStrs[0];
            //字符数组中的第二个 前缀
            String oldStr = popStrs[1];
            for (int i = statckStr.length() - 1; i >= 0; i--) {
                //遍历stackStr
                //strs 数组
                //[0] 截取statckStr 0->i 加上 statckStr i+1->结束  最终结果 statckStr 去除第 i 位字符     排列之后余下的字符串
                //[1] oldstr + statckStr i->i+1                   最终结果 oldstr + statckStr 第i位字符 前缀+本次后缀
                String[] strs = new String[]{statckStr.substring(0, i) + statckStr.substring(i + 1),
                        oldStr + statckStr.substring(i, i + 1)};
                if (strs[0].length() == 0) {
                    //statckStr 去除第 i 位字符 为空
                    // oldstr + statckStr 第i位字符 就是一种排列
                    tree.add(strs[1]);
                } else {
                    //statckStr 去除第 i 位字符 不为空
                    stack.push(strs);
                }
            }
        } while (!stack.isEmpty());
        return new ArrayList<>(tree);
    }
}