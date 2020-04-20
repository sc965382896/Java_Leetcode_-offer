package LeetCode;

// 岛屿数量：相连的岛屿算一个岛屿
// DFS、BFS、并查集

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    // 并查集
    class UnionFind {
        int count;
        int[] parent;
        int[] rank;
        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        ++count;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }
        public int find(int i) {
            if (parent[i] != i) parent[i] = find(parent[i]);
            return parent[i];
        }
        public int getCount() {
            return count;
        }
        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    rank[rootx] += 1;
                }
                --count;
            }
        }
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    grid[row][col] = '0';
                    if (row - 1 >=0 && grid[row - 1][col] == '1') {
                        uf.union(row * cols + col, (row - 1) * cols + col);
                    }
                    if (row + 1 < rows && grid[row + 1][col] == '1') {
                        uf.union(row * cols + col, (row + 1) * cols + col);
                    }
                    if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                        uf.union(row * cols + col, row * cols + col - 1);
                    }
                    if (col + 1 < cols && grid[row][col + 1] == '1') {
                        uf.union(row * cols + col, row * cols + col + 1);
                    }
                }
            }
        }
        return uf.getCount();
    }
    // BFS
    public int numIslandsWithBFS(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    ++count;
                    grid[row][col] = '0';
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(row * cols + col);
                    while (!queue.isEmpty()) {
                        int id = queue.poll();
                        // 这个地方需要注意，除数是cols而不是rows。
                        int r = id / cols;
                        int c = id % cols;
                        if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                            grid[r - 1][c] = '0';
                            queue.offer((r - 1) * cols + c);
                        }
                        if (r + 1 < rows && grid[r + 1][c] == '1') {
                            grid[r + 1][c] = '0';
                            queue.offer((r + 1) * cols + c);
                        }
                        if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                            grid[r][c - 1] = '0';
                            queue.offer(r * cols + c - 1);
                        }
                        if (c + 1 < cols && grid[r][c + 1] == '1') {
                            grid[r][c + 1] = '0';
                            queue.offer(r * cols + c + 1);
                        }
                    }
                }
            }
        }
        return count;
    }

    // dfs
    public int numIslandsWithDFS(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    ++count;
                    dfs(grid, rows, cols, row, col);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int rows, int cols, int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == '1') {
            grid[row][col] = '0';
            dfs(grid, rows, cols, row + 1, col);
            dfs(grid, rows, cols, row - 1, col);
            dfs(grid, rows, cols, row, col + 1);
            dfs(grid, rows, cols, row, col - 1);
        }
    }
}
