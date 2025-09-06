class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] prev = new int[n][n];
        int[][] curr = new int[n][n];
        for (int j1 = 0; j1 < n; j1++) {
            for (int j2 = 0; j2 < n; j2++) {
                if (j1 == j2)
                    prev[j1][j2] = grid[m - 1][j1];
                else
                    prev[j1][j2] = grid[m - 1][j1] + grid[m - 1][j2];
            }
        }
        for (int i = m - 2; i >= 0; i--) {
            curr = new int[n][n]; 
            for (int j1 = 0; j1 < n; j1++) {
                for (int j2 = 0; j2 < n; j2++) {
                    int maxi = (int) -1e8;
                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            if (j1 + dj1 < 0 || j1 + dj1 >= n || j2 + dj2 < 0 || j2 + dj2 >= n)
                                continue;
                            else {
                                if (j1 == j2)
                                    maxi = Math.max(maxi, grid[i][j1] + prev[j1 + dj1][j2 + dj2]);
                                else
                                    maxi = Math.max(maxi, grid[i][j1] + grid[i][j2] + prev[j1 + dj1][j2 + dj2]);
                            }
                        }
                    }
                    curr[j1][j2] = maxi;
                }
            }
            prev=curr;
        }

        return prev[0][n - 1];
    }
}