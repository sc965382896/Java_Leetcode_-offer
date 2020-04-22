package LeetCode;

import java.util.Stack;

public class TrappingRainWater {
    // 暴力法，T(n) = O(n^2), S(n) = O(1)。
    // 对每一个位置都查找两侧最高位置，然后与两者低的做差求和。
    public int trap1(int[] height) {
        if (height == null || height.length < 3)
            return 0;
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = height[i];
            int maxRight = height[i];
            for (int j = i - 1; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i + 1; j < height.length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            // 为什么可以直接减呢？
            // 因为保存的两侧高度最低也是它本身的高度。
            res += Math.min(maxLeft, maxRight) - height[i];
        }
        return res;
    }
    // 动态规划，T(n) = O(n)，S(n) = O(n)
    // 借助两个数组保存每个位置两侧的高度，
    // 利用每个位置左右两个位置的两侧高度来判断，
    // 从而不必重复扫描整个数组。
    public int trap2(int[] height) {
        if (height == null || height.length < 3)
            return 0;
        int res = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        maxLeft[0] = height[0];
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }
        maxRight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i > 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            res += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return res;
    }
    // 单调栈法，T(n) = O(n)，S(n) = O(n)。
    // 通过栈保存凹槽和平层，计算时根据相差的高度和宽度计算，逐层累加。
    public int trap3(int[] height) {
        if (height == null || height.length < 3)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int current = 0;
        while (current < height.length) {
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = stack.pop();
                if (stack.empty())
                    break;
                int distance = current - stack.peek() - 1;
                res += distance * (Math.min(height[current], height[stack.peek()]));
            }
            stack.push(current++);
        }
        return res;
    }
    // 双指针法，T(n) = O(n)，S(n) = O(1)。
    // 原理是：接水量取决于较低的那一侧，遍历到某个位置时，则之前保存的高度一定是目前最低的，
    // 高的那一侧及时中间有低的因为高的存在也可以满足接水条件。
    public int trap4(int[] height) {
        if (height == null || height.length < 3)
            return 0;
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        while (left <= right) {
            if (maxLeft < maxRight) {
                maxLeft = Math.max(maxLeft, height[left]);
                res += maxLeft - height[left];
                ++left;
            } else {
                maxRight = Math.max(maxRight, height[right]);
                res += maxRight - height[right];
                --right;
            }
        }
        return res;
    }
}
