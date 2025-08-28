class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1)
            return 0;
        int[] arr = new int[n];
        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                int up = 0, left = 0;
                if (obstacleGrid[i][j] != 0)
                    temp[j] = 0;
                else if (i == 0 && j == 0)
                    temp[j] = 1;
                else {
                    if (i > 0)
                        up = arr[j];
                    if (j > 0)
                        left = temp[j - 1];
                    temp[j] = up + left;
                }
            }
            for (int jk = 0; jk < n; jk++) {
                arr[jk] = temp[jk];
            }
        }
        return arr[n - 1];
    }
}