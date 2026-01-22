class Pair {
    int u, v;

    Pair(int u, int v) {
        this.u = u;
        this.v = v;
    }
}

class Solution {
    public int[][] search(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] visited = new int[m][n];
        int[][] dist = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new Pair(i, j));
                    visited[i][j] = 1;
                }
            }
        }
        int[] drow = { -1, 0, +1, 0 };
        int[] dcol = { 0, +1, 0, -1 };
        while (!q.isEmpty()) {
            int row = q.peek().u;
            int col = q.peek().v;
            q.poll();
            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && visited[nrow][ncol] == 0) {
                    dist[nrow][ncol] = dist[row][col] + 1;
                    visited[nrow][ncol] = 1;
                    q.offer(new Pair(nrow, ncol));
                }
            }

        }
        return dist;
    }

    public int[][] updateMatrix(int[][] mat) {
        return search(mat);

    }
}