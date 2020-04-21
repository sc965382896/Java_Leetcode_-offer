package LeetCode;

import java.util.HashSet;
import java.util.Set;

// 最长连续序列
// 哈希表+遍历：O(n)的原因是查询是O(1)的，只有当不含比当前数字小的数字时才会进行遍历。

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null)
            return 0;
        int longestStreak = 0;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        for (int num : nums) {
            if (!numSet.contains(num - 1)) {
                int curStreak = 1;
                int curNum = num + 1;
                while (numSet.contains(curNum)) {
                    ++curStreak;
                    ++curNum;
                }
                longestStreak = Math.max(longestStreak, curStreak);
            }
        }
        return longestStreak;
    }
}
