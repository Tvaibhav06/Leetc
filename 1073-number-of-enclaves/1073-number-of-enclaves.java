class Solution {
    public void DFS(int[][] grid, int u, int v) {
        int m = grid.length;
        int n = grid[0].length;
        if (u < 0 || u >= m || v < 0 || v >= n || grid[u][v] == 0)
            return;
        grid[u][v] = 0;
        DFS(grid, u - 1, v);
        DFS(grid, u, v + 1);
        DFS(grid, u + 1, v);
        DFS(grid, u, v - 1);
    }

    public int fixit(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1) {
                DFS(grid, 0, i);
            }
            if (grid[m - 1][i] == 1) {
                DFS(grid, m - 1, i);
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (grid[i][0] == 1) {
                DFS(grid, i, 0);
            }
            if (grid[i][n - 1] == 1) {
                DFS(grid, i, n - 1);
            }
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cnt += grid[i][j];
            }
        }
        return cnt;
    }

    public int numEnclaves(int[][] grid) {
        return fixit(grid);
    }
}