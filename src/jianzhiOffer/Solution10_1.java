package jianzhiOffer;

// 面试题10-1：斐波那契序列
// 递归或者动态规划

public class Solution10_1 {
    public int Fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int f1 = 0;
        int f2 = 1;
        int fn = 0;
        for (int i = 2; i <= n; i++) {
            fn = f1 + f2;
            f1 = f2;
            f2 = fn;
        }
        return fn;
    }
}
