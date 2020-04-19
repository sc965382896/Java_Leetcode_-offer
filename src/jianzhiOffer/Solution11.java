package jianzhiOffer;

// 面试题11：旋转数组的最小数字
// 利用旋转数组的特点，采用二分查找的方式。

public class Solution11 {
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length <= 1)
            return 0;
        int start = 0;
        int end = array.length - 1;
        int mid = start;
        while (array[start] >= array[end]) {
            if (end - start == 1) {
                mid = end;
                break;
            }
            mid = (start + end) >> 1;
            if (array[mid] == array[start] && array[mid] == array[end])
                return minNumber(array, start, end);
            if (array[start] <= array[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return array[mid];
    }
    public int minNumber(int[] array, int start, int end) {
        int min = array[start];
        for (int i = start + 1; i <= end; i++) {
            if (array[i] < min)
                min = array[i];
        }
        return min;
    }
}
