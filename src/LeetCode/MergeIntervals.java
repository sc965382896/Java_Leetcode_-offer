package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 合并区间
// 先排序，然后合并。合并的原则：如果前一个区间包含后一个区间，则跳过。如果前一个区间与后一个区间交叉，则合并。如果都不，存储前一区间，并从当前区间开始进行合并。
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1)
            return intervals;
        List<int[]> res = new ArrayList<>();
        quickSort(intervals);
        int[] temp = intervals[0];
        for (int i = 0; i < intervals.length; i++) {
            // 这里需要注意，因为存在包含的可能，需要加一个判断。
            if (intervals[i][1] <= temp[1])
                continue;
            if (intervals[i][0] <= temp[1]) {
                temp[1] = intervals[i][1];
            } else {
                res.add(temp);
                temp = intervals[i];
            }
        }
        res.add(temp);
        return res.toArray(new int[res.size()][]);
    }
    public void quickSort(int[][] intervals) {
        int start = 0;
        int end = intervals.length - 1;
        quickSort(intervals, start, end);
    }
    public void quickSort(int[][] intervals, int start, int end) {
        // 特别注意这个边界条件！！！
        if (start >= end)
            return;
        int index = partition(intervals, start, end);
        if (start < index) quickSort(intervals, start, index - 1);
        if (index < end) quickSort(intervals, index + 1, end);
    }
    public int partition(int[][] intervals, int start, int end) {
        if (intervals == null || intervals.length == 0 || start < 0 || end >= intervals.length)
            return -1;
        int j = start - 1;
        for (int i = start; i < end; i++) {
            if (intervals[i][0] < intervals[end][0]) {
                j++;
                if (i != j) {
                    swap(intervals, i, j);
                }
            }
        }
        j++;
        swap(intervals, j ,end);
        return j;
    }
    public void swap(int[][] intervals, int i, int j) {
        int[] temp = intervals[i];
        intervals[i] = intervals[j];
        intervals[j] = temp;
    }

    public static void main(String[] args) {
        int[] ints = new int[0];
        System.out.println(ints);
    }
}
