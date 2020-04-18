import sun.security.util.Length;

import java.util.Arrays;

public class Sort {
    // 选择排序
    public void sort1(int[] data) {
        if (data == null || data.length <= 1)
            return;
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[i]) {
                    swap(data, i, j);
                }
            }
        }
    }
    // 冒泡排序
    public void sort2(int[] data) {
        if (data == null || data.length <= 1)
            return;
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j + 1] < data[j]) {
                    swap(data, j, j + 1);
                }
            }
        }
    }
    // 插入排序
    public void sort3(int[] data) {
        if (data == null || data.length <= 1)
            return;
        for (int i = 1; i < data.length; i++) {
            int temp = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > temp) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = temp;
        }
    }
    // 快速排序
    public void sort4(int[] data) {
        if (data == null || data.length <= 1)
            return;
        int start = 0;
        int end = data.length - 1;
        quickSort(data, start, end);
    }
    // 归并排序
    public void sort5(int[] data) {
        int start = 0;
        int end = data.length - 1;
        int[] temp = new int[data.length];
//        int[] temp = Arrays.copyOf(data, data.length);
//        mergeSort1(data, temp, start, end);
        mergeSort2(data, temp, start, end);
    }
    public void mergeSort1(int[] data, int[] temp, int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) >> 1;
        mergeSort1(temp, data, start, mid);
        mergeSort1(temp, data, mid + 1, end);
        mergeArray1(data, temp, start, mid, end);
    }
    public void mergeArray1(int[] data, int[] temp, int start, int mid, int end) {
        int l = start;
        int r = mid + 1;
        int index = start;
        while (l <= mid && r <= end) {
            if (temp[l] < temp[r]) {
                data[index++] = temp[l++];
            } else {
                data[index++] = temp[r++];
            }
        }
        while (l <= mid) {
            data[index++] = temp[l++];
        }
        while (r <= end) {
            data[index++] = temp[r++];
        }
    }
    public void mergeSort2(int[] data, int[] temp, int start, int end) {
        if (start < end) {
            int mid = (start + end) >> 1;
            mergeSort2(data, temp, start, mid);
            mergeSort2(data, temp, mid + 1, end);
            mergeArray2(data, temp, start, mid, end);
        }
    }
    public void mergeArray2(int[] data, int[] temp, int start, int mid, int end) {
        int l = start;
        int r = mid + 1;
        int index = 0;
        while (l <= mid && r <= end) {
            if (data[l] < data[r]) {
                temp[index++] = data[l++];
            } else {
                temp[index++] = data[r++];
            }
        }
        while (l <= mid) {
            temp[index++] = data[l++];
        }
        while (r <= end) {
            temp[index++] = data[r++];
        }
        index = 0;
        while (start <= end) {
            data[start++] = temp[index++];
        }
    }
    public void quickSort(int[] data, int start, int end) {
        if (start >= end)
            return;
        int index = partition1( data, start, end);
        if (index < end) quickSort(data, index + 1, end);
        if (start < index) quickSort(data, start, index - 1);

//        if (start < end) {
//            int index = partition2(data, start, end);
//            quickSort(data, start , index - 1);
//            quickSort(data, index + 1, end);
//        }
    }
    public int partition1(int[] data, int start, int end) {
        if (data == null || data.length <= 0 || start < 0 || end >= data.length)
            return -1;
        int j = start - 1;
        for (int i = start; i < end; i++) {
            if (data[i] < data[end]) {
                j++;
                if (i != j)
                    swap(data, i, j);
            }
        }
        // 注意这一点，最后还要把尾部数值放到中间。
        j++;
        swap(data, j, end);
        return j;
    }
    public int partition2(int[] data, int start, int end) {
        int i = start;
        int j = end;
        // 双指针填坑时需要保存尾部的值。
        int temp = data[end];
        while (i < j) {
            while (i < j && data[i] < temp)
                i++;
            if (i < j)
                // 注意这种地方是将违规的数据填到坑里。
                data[j--] = data[i];
            while (i < j && data[j] >= temp)
                j--;
            if (i < j)
                data[i++] = data[j];
        }
        // 最后需要填充该位置。
        data[i] = temp;
        return i;
    }
    public void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] list1 = {6, 2, 1, 5, 7, 2};
        sort.sort4(list1);
        for (int value : list1) {
            System.out.println(value);
        }
    }
}
