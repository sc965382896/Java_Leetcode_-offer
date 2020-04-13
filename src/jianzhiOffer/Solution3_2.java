package jianzhiOffer;

// 面试题3-2：不修改数组找出重复的数字

public class Solution3_2 {
    public static int duplicate(int[] numbers, int length) {
        if (numbers == null || length < 2) return -1;
        int start = 1;
        int end = length - 1;
        while (start <= end) {
            int middle = (start + end) >> 1;
            int count = countNum(numbers, start, middle);
            if (start == end && count >= 2) {
                return numbers[start];
            } else if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }
    public static int countNum(int[] numbers, int begin, int end) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= begin && numbers[i] <= end) count++;
        }
        return count;
    }

}