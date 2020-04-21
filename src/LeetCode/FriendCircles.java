package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

// 朋友圈
// DFS、BFS：可以修改数组的值，省去visited数组。需要注意的是，不能像并查集那样初始化索引为i+1，因为可能出现0->4->2这种顺序的图。
// 并查集，可以只合并右上角的部分，减少运算量。
public class FriendCircles {
    class UnionFind {
        int count;
        int[] parent;
        int[] rank;
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
        public int getCount() {
            return count;
        }
        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }
        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            System.out.println("rootx: " + rootx + ", rooty: " + rooty);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rooty] > rank[rootx]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    ++rank[rootx];
                }
                --count;
            }
        }
    }
    public int findCircleNumWithUnionFind(int[][] M) {
        if (M == null || M.length == 0)
            return 0;
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0)
            return 0;
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (M[i][i] == 1) {
                M[i][i] = 0;
                queue.add(i);
                ++count;
                while (!queue.isEmpty()) {
                    int m = queue.remove();
                    for (int j = 0; j < M.length; j++) {
                        if (M[j][j] == 1 && M[m][j] == 1) {
                            M[j][j] = 0;
                            queue.add(j);
                        }
                    }
                }
            }
        }
        return count;
    }
    public int findCircleNumWithDFS(int[][] M) {
        if (M == null || M.length == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (M[i][i] == 1) {
                M[i][i] = 0;
                dfs(M, i);
                ++count;
            }
        }
        return count;
    }
    public void dfs(int[][] M, int i) {
        // 下面的用法错误，与使用并查集的方法不同，因为递归时会出现0->3->1，如果使用下面的方法，就会漏掉1。
        // for (int j = i + 1; j < M.length; j++) {
        for (int j = 0; j < M.length; j++) {
            if (M[j][j] == 1 && M[i][j] == 1) {
                M[j][j] = 0;
                dfs(M, j);
            }
        }
    }
    public static void main(String[] args) {

    }
}
