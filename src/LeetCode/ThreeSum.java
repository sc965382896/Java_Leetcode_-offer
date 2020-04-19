package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 三数之和
// 排序+双指针，遇到重复数字就跳过，防止出现重复的组合。

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum == 0) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[l]);
                        tmp.add(nums[r]);
                        res.add(tmp);
                        // 这里需要注意必须用do-while，因为如果不至少执行一次的话，有可能会造成指针不移动，而陷入死循环。
                        do {
                            l++;
                        } while (l < r && nums[l] == nums[l - 1]);
                        do {
                            r--;
                        } while (l < r && nums[r] == nums[r + 1]);
                    } else if (sum > 0) {
                        do {
                            r--;
                        } while (l < r && nums[r] == nums[r + 1]);
                    } else {
                        do {
                            l++;
                        } while (l < r && nums[l] == nums[l - 1]);
                    }
                }
            }
        }
        return res;
    }
}
