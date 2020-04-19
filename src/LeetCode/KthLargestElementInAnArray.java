package LeetCode;

// 第k大的元素
// 返回第k大元素值，而不是索引，因此可以改变数组。
// 使用partition函数。

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k)
            return -1;
        int target = nums.length - k;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int index = partition(nums, start, end);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                start = index + 1;
            } else {
                end = index - 1;
            }
        }
        return -1;
    }
    public int partition(int[] nums, int start, int end) {
        if (nums == null || nums.length <= 0 || start < 0 || end >= nums.length)
            return -1;
        int j = start - 1;
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[end]) {
                j++;
                if (i != j) {
                    swap(nums, i, j);
                }
            }
        }
        j++;
        swap(nums, j, end);
        return j;
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
