package com.liquor.leetcode;

/**
 * 接雨水
 * <p>
 * https://leetcode.cn/problems/trapping-rain-water/
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        var arr = new int[]{1, 2, 3, 4, 3, 2, 1};
        System.out.println(trapping(arr));
    }

    /**
     * 备忘录解法
     */
    static int trapping(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        var len = height.length;

        var max = 0;
        var leftMax = new int[len];
        var rightMax = new int[len];
        leftMax[0] = height[0];
        rightMax[len - 1] = height[len - 1];

        // 从左往右计算左侧最高的柱子, 包括了自己（兼容自己就是最高的情况）
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // i 位置能接的雨水，是左右两侧最高的柱子之中较小的那个，减去 i 位置柱子的数量
        // 两边的元素，相当于是木桶的边，不参与计算，只有中间形成了碗才可以计算
        for (int i = 1; i < len - 1; i++) {
            var lMax = leftMax[i];
            var rMax = rightMax[i];
            max += Math.min(lMax, rMax) - height[i];
        }

        return max;
    }

}
