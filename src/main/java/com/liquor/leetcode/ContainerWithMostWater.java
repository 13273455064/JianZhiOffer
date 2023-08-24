package com.liquor.leetcode;

/**
 * 盛水最多的容器
 * <p>
 * https://leetcode.cn/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        var left = 0;
        var right = height.length - 1;
        var res = 0;

        while (left < right) {

            var area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, area);

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }


        return res;
    }
}
