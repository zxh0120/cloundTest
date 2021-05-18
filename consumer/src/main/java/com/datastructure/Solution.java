package com.datastructure;

/**
 * @author zhouxiaohui
 * @blame Lanxum
 * @Description
 *      给定一个 haystack 字符串和一个 needle 字符串，
 *      在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 *      如果不存在，则返回 -1。
 * @since 2021/4/26
 **/
public class Solution {
    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        int num = findStr(haystack, needle);
        System.out.println(num);
    }

    public  static int findStr(String haystack, String needle) {
        int haylen = haystack.length();
        int needlen = needle.length();
        //特殊情况
        if (haylen < needlen) {
            return -1;
        }
        if (needlen == 0) {
            return 0;
        }
        //主串
        for (int i = 0; i < haylen - needlen + 1; ++i) {
            int j;
            //模式串
            for (j = 0; j < needlen; j++) {
                //不符合的情况，直接跳出，主串指针后移一位
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            //匹配成功
            if (j == needlen) {
                return i;
            }
        }
        return -1;
    }
}
