class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
                if (i == 0 && j == 0)
                    dp[0][0] = grid[0][0];
                else {
                    if (i > 0)
                        left = dp[i - 1][j];
                    if (j > 0)
                        up = dp[i][j - 1];
                     dp[i][j] = grid[i][j] + Math.min(left, up);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}