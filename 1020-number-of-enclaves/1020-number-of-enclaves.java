class Solution {
    public void move(int[][] grid,int i,int j){
        int m=grid.length;     
        int n=grid[0].length; 
        if(i<0||j<0||i>m-1||j>n-1||grid[i][j]==0){
            return;
        }
        grid[i][j]=0;
        move(grid,i-1,j);
        move(grid,i,j+1);
        move(grid,i+1,j);
        move(grid,i,j-1);
    }
    public int numEnclaves(int[][] grid) {
        int m=grid.length;     
        int n=grid[0].length;    
        for(int i=0;i<m;i++){
            if(grid[i][0]==1){
                move(grid,i,0);
            }
             if(grid[i][n-1]==1){
                move(grid,i,n-1);
            }
        }
        for(int i=0;i<n;i++){
            if(grid[0][i]==1){
                move(grid,0,i);
            }
             if(grid[m-1][i]==1){
                move(grid,m-1,i);
            }
        }
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                    cnt+=grid[i][j];
            }
        }
        return cnt;
    }
}