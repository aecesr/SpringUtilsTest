package com.chl.springdemo.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @version 1.0
 * @Author caohl
 * @Date 2024/1/10 17:44
 * @注释 有效得括号
 */
public class LeetCodeIsValid {
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

    public static void main(String[] args) {
        System.out.println(isValid("()()(){}{}{}[][]"));
    }

}
