package com.chl.springdemo.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @version 1.0
 * @Author caohl
 * @Date 2024/1/10 17:44
 * @注释
 */
public class LeetCode {
    /**
     * 有效得括号
     */
    public static boolean isValid(String s) {
        if (s.length()%2!=0) {
            return false;
        }
        Deque<String> characters = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            String c = s.substring(i,i+1);
            if ("(".equals(c)) {
                characters.push(")");
            }else if  ("[".equals(c)) {
                characters.push("]");
            }else if  ("{".equals(c)) {
                characters.push("}");
            } else if (characters.isEmpty() || characters.peek() == c) {
                return false;
            }else {
                return characters.isEmpty();
            }
        }
        return true;
    }


    /**
     * 找出字符串中第一个匹配项的下标
     */
    public static int strStr(String haystack, String needle) {

        int length = needle.length();
        for (int i = 0; i < haystack.length(); i++) {
            if (i + length > haystack.length()) {
                return  -1;
            }
            String substring = haystack.substring(i, i + length);
            if (substring.equals(needle)) {
                return i;
            }
        }
        return -1;

    }

    public static String longestCommonPrefix(String[] strs) {
//        if (strs.length ==1) {
//            return strs[0];
//        }
//        if (strs.length == 0) {
//            return "";
//        }
//        String pub = strs[0];
//        for (int i = 0; i < strs.length; i++) {
//            if (i + 1 == strs.length) {
//                return pub;
//            }
//            int min = Math.min(strs[i].length(), strs[i + 1].length());
//            for ( int j = 0; j < min; j++) {
//                if (strs[i].charAt(j) != strs[i+1].charAt(j)) {
//                    if (j <= pub.length()) {
//                        pub = pub.substring(0, j);
//                    }
//                    break;
//                }
//                pub = pub.substring(0, ++j);
//            }
//
//        }
//        return pub;
        if (strs.length ==1) {
            return strs[0];
        }
        if (strs.length == 0) {
            return "";
        }
        String pub = "";
        for (int i = 0; i < strs.length; i++) {
            if (i + 1 == strs.length) {
                return pub;
            }
            String a ="";
            int min = Math.min(strs[i].length(), strs[i + 1].length());
            if (min == 0) {
                return "";
            }
            for ( int j = 0; j < min; j++) {
                if (strs[i].charAt(j) != strs[i+1].charAt(j)) {
                    break;
                }else {
                    a += strs[i].charAt(j);
                }
            }
            pub = a;


        }
        return pub;
    }
    public static int removeElement(int[] nums, int val) {
        int i = -1;
        for (int i1 = 0; i1 < nums.length; i1++) {
            if (nums[i1] != val) {
                nums[++i] = nums[i1];
            }
        }
        return ++i;
    }


    public static void main(String[] args) {
        // 有效得括号
        // System.out.println(isValid("()()(){}{}{}[][]"));

        // [28]找出字符串中第一个匹配项的下标.java
        // System.out.println(strStr("a", "a"));
        // 最长公共前缀
        // System.out.println(longestCommonPrefix(new String[]{"baab","bacb","b","cbc"}));

        // 移除元素
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
    }

}
