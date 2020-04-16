package LeetCode;

import java.util.ArrayList;
import java.util.List;

// 第k个排列

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        if (n <= 0) return "";
        k--;
        int[] factorialNum = new int[n];
        factorialNum[0] = 1;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 1; i < n; i++) {
            factorialNum[i] = factorialNum[i - 1] * i;
            list.add(i + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            sb.append(list.remove(k / factorialNum[i]));
            k %= factorialNum[i];
        }
        return sb.toString();
    }
}
