package LeetCode;

// 最大子序和
// 动态规划
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int curSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 使用Math.max可以简化代码。
            curSum = Math.max(curSum, 0) + nums[i];
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }
}
