package LeetCode;

import java.util.ArrayList;
import java.util.List;

// 数组中重复的数据
// 利用数字对应位置元素的正负号表示是否出现过。

public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length <= 1)
            return res;
        for (int num : nums) {
            int index = Math.abs(nums[num]) - 1;
            if (nums[index] < 0) {
                res.add(index + 1);
            }
            nums[index] = -nums[index];
        }
        return res;
    }
}
