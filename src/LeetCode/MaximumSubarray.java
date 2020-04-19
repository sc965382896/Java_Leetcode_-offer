package LeetCode;

// 最大子序和

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int curSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (curSum <= 0) {
                curSum = nums[i];
            } else {
                curSum += nums[i];
            }
            if (curSum > maxSum)
                maxSum = curSum;
        }
        return maxSum;
    }
}
