package LeetCode;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int index = nums.length - 2;
        while (index >= 0) {
            if (nums[index] < nums[index + 1]){
                break;
            }
            index--;
        }
        if (index >= 0) {
            int n = index + 1;
            while (n < nums.length) {
                if (nums[n] <= nums[index])
                    break;
                n++;
            }
            swap(nums, index, n - 1);
        }
        quickSort(nums, index + 1, nums.length - 1);
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void quickSort(int[] nums, int start, int end) {
        if (start >= end)
            return;
        int index = partition(nums, start, end);
        if (index < end) quickSort(nums, index + 1, end);
        if (index > start) quickSort(nums, start, index - 1);
    }
    public int partition(int[] nums, int start, int end) {
        if (nums == null || nums.length <=0 || start < 0 || end >= nums.length)
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
}
