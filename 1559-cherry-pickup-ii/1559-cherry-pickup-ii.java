class Solution {
    public int jumps(int[][] grid,int[][][] dp,int i,int j1,int j2){
        if(j1<0||j1>grid[0].length-1||j2<0||j2>grid[0].length-1)return (int)-1e8;
        if(dp[i][j1][j2]!=-1)return dp[i][j1][j2];
        if(i==grid.length-1){
            if(j1==j2)return grid[i][j1];
            else{
                return grid[i][j1]+grid[i][j2];
            }
        }
        int maxi=(int)-1e8;
        for(int dj1=-1;dj1<=1;dj1++){
            for(int dj2=-1;dj2<=1;dj2++){
                if(j1==j2) maxi=Math.max(maxi,grid[i][j1]+jumps(grid,dp,i+1,j1+dj1,j2+dj2));
                else maxi=Math.max(maxi,grid[i][j1]+grid[i][j2]+jumps(grid,dp,i+1,j1+dj1,j2+dj2));
            }
        }
        return dp[i][j1][j2]=maxi;
     }
    public int cherryPickup(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][][] dp=new int[m][n][n];
        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }
        
        return jumps(grid,dp,0,0,n-1);
    }
}