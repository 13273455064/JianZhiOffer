package com.liquor.leetcode;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，有一个大小为的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zzc on 2021.1.2
 */
public class SlidingWindowMaximum {


    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }


    /**
     * 暴力循环，时间复杂度O(kn)
     * 在leetcode上部分测试用例超时
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int start = 0;
        int end = start + k -1;
        int[] result = new int[nums.length - k + 1];
        while(end < nums.length){
            int max = nums[start];
            for(int i=start;i<=end;i++){
                if(nums[i]>max){
                    max = nums[i];
                }
            }
            result[start] = max;
            start++;
            end++;
        }
        return result;
    }


}
