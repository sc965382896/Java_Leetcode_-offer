package LeetCode;

// 岛屿的最大面积
// dfs+沉岛思想
// 时间复杂度：O(R*C)；空间复杂度：O(R*C)
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    //使用Math.max代替判断，代码更简洁。
                    maxArea = Math.max(maxArea, maxAreaOfIslandCore(grid, rows, cols, row, col));
//                    if (curArea > maxArea) {
//                        maxArea = curArea;
//                    }
                }
            }
        }
        return maxArea;
    }
    public int maxAreaOfIslandCore(int[][] grid, int rows, int cols, int row, int col) {
        if (row >= rows || row < 0 || col >= cols || col < 0 || grid[row][col] == 0) {
            return 0;
        }
        // 沉岛思想，当一个岛到达之后，则使周围的岛看不到该岛的存在。
        grid[row][col] = 0;
        return 1 + maxAreaOfIslandCore(grid, rows, cols, row + 1, col)
                + maxAreaOfIslandCore(grid, rows, cols, row - 1, col)
                + maxAreaOfIslandCore(grid, rows, cols, row, col + 1)
                + maxAreaOfIslandCore(grid, rows, cols, row, col - 1);
    }
}
