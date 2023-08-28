package com.liquor.leetcode.array;

/**
 * 长度最小的子数组
 * <p>
 * https://leetcode.cn/problems/2VG8Kg/description/
 */
public class MinLenSubArray {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        var left = 0;
        var right = 0;
        var sum = 0;
        var minLen = Integer.MAX_VALUE;

        while (right < nums.length) {

            sum += nums[right];

            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;

    }

}
