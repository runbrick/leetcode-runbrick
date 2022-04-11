package com.runbrick.app;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 力扣第 3 题: 无重复字符的最长子串
 * 难度：简单
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * TODO: 跳过目前没有研究明白
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcefabcefbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)){
                start = Math.max(map.get(ch)+1,start);
            }
            max = Math.max(max,end - start + 1);
            map.put(ch,end);
        }
        return max;
    }
}
