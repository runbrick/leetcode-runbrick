package com.runbrick.app;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 力扣第 1 题: 两数之和
 * 难度：简单
 * https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    /**
     * 使用 HashMap 反推求和，
     * 例如 nums [2, 7, 11, 15 ] target 9 那么 9 - 7 = 2 而且同一个下标不能用两次 所以得出数组下标为 [0,1].
     */
    public static int[] twoSum(int[] nums, int target) {
        // 创建一个 HashMap 用来存储遍历出来的 num 和 数组下标
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{};
    }
}
