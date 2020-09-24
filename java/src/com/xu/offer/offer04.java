package com.xu.offer;

/**
 * 剑指offer替换空格测试用例
 */
public class offer04 {
    public static void main(String[] args) {
//        StringBuffer stringBuffer = new StringBuffer(" abb c");
//        String s = replaceSpace(stringBuffer);
        System.out.println(3%2);
    }

    public static String replaceSpace(StringBuffer str) {
        //记录字符串的长度，在遍历替换的时候使用
        int p1 = str.length() - 1;
        System.out.println(p1);
        //增加字符串的容量
        for (int i = 0; i <= p1; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
            System.out.println(str);
            //储存新的字符串长度
            int p2 = str.length() - 1;
            System.out.println(p2);
            //边界条件
            while (p1 >= 0 && p1 < p2) {
                //当p1不是空字符的时候
                if (str.charAt(p1) != ' ') {
                    str.setCharAt(p2--, str.charAt(p1--));
                } else {
                    str.setCharAt(p2--, '0');
                    str.setCharAt(p2--, '2');
                    str.setCharAt(p2--, '%');
                    p1--;
                }
            }
        return str.toString();
    }
}
