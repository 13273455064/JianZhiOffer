package com.liquor.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * <p>
 * https://leetcode.cn/problems/3sum/
 */
public class Sum3 {


    public List<List<Integer>> threeSum(int[] nums) {
        // 先排序
        Arrays.sort(nums);

        return find(nums, 0, 3, 0);
    }

    /* 注意：调用这个函数之前一定要先给 nums 排序 */
    // n 填写想求的是几数之和，start 从哪个索引开始计算（一般填 0），target 填想凑出的目标和


    private List<List<Integer>> find(int[] nums, int target, int n, int start) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < 2 || nums.length < n) {
            return result;
        }
        if (n == 2) {
            // 从 start 开始
            var left = start;
            var right = nums.length - 1;

            while (left < right) {
                var sum = nums[left] + nums[right];
                var leftNum = nums[left];
                var rightNum = nums[right];
                if (sum == target) {
                    result.add(new ArrayList<>(List.of(leftNum, rightNum)));
                    // 排除重复元素
                    while (left < right && leftNum == nums[left]) {
                        left++;
                    }
                    while (left < right && rightNum == nums[right]) {
                        right--;
                    }
                }
                if (sum > target) {
                    while (left < right && rightNum == nums[right]) {
                        right--;
                    }
                }
                if (sum < target) {
                    while (left < right && leftNum == nums[left]) {
                        left++;
                    }
                }
            }
        } else {
            // 需要挨个计算 nums 数组中每个元素子问题的解
            for (int i = start; i < nums.length; i++) {
                var sub = find(nums, target - nums[i], n - 1, i + 1);
                // 每个子问题都要加当前数字
                for (List<Integer> list : sub) {
                    if (list.isEmpty()) {
                        continue;
                    }
                    list.add(nums[i]);
                    result.add(list);
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }

        return result;
    }


}
