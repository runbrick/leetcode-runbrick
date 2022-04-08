package com.runbrick.app;

import java.util.HashMap;
import java.util.Map;

/**
 * 力扣第 13 题: 两数之和
 * 难度：简单
 * https://leetcode-cn.com/problems/roman-to-integer/
 */
public class RomanToInteger {
    /**
     * 定义字典值
     */
    static Map<Character, Integer> roManDictionary = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public static void main(String[] args) {
        String s = "MCMXCIV"; // 1000 - 100 + 1000 - 10 + 100 - 1 + 5 = 1994
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = roManDictionary.get(s.charAt(i));
            // 每轮比下一个数如果大于下一个数就 ans 加上当前数 如果小于下一个数就 ans减去当前数
            if (i < n - 1 && value < roManDictionary.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }
}
