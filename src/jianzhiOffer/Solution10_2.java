package jianzhiOffer;

// 面试题10-2：青蛙跳台阶
// 采用动态规划的方法。

public class Solution10_2 {
    public int numWays(int n) {
        if (n < 3)
            return n;
        int f1 = 1;
        int f2 = 2;
        int fn = 0;
        for (int i = 3; i <= n; i++) {
            // 这里取模防止大数值越界。
            fn = (f1 + f2) % 1000000007;
            f1 = f2;
            f2 = fn;
        }
        return fn;
    }
}
