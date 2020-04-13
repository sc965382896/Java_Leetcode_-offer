package jianzhiOffer;

// 面试题4：二维数组中的查找
// 思路：因为数组从左向右，从上往下分别递增。从右上角上开始，可以保证每次都缩小一行或一列的范围。

public class Solution4 {
    public static boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0)
            return false;
        int rows = array.length;
        int cols = array[0].length;
        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            if (array[row][col] == target) {
                return true;
            } else if (array[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
