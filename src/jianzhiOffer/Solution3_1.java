package jianzhiOffer;

// 面试题3： 数组中重复的数字
// 思路：遍历数组，将数字放在与其大小一致的位置，同时进行判断。
// 测试用例：1、含有重复的；2、不含重复的；3、空数组或数组长度为0或1，或者数组中包含0~n-1之外的。

public class Solution3_1 {
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        // 防止输入为空抛异常，长度为0或1肯定不包含，提前进行判断。
        if (numbers == null || length < 2) return false;

        // 防止输入中包含超出索引范围的数字。
        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] >= length) return false;
        }

        // 判定的主体
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                int index = numbers[i];
                if (numbers[index] == index) {
                    duplication[0] = index;
                    return true;
                } else {
                    int temp = numbers[index];
                    numbers[index] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        return false;
    }

}