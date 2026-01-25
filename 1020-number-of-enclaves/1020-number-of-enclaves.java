class Solution {
    public void move(int[][] grid,int[][] visited,int i,int j){
        int m=grid.length;     
        int n=grid[0].length; 
        if(i<0||j<0||i>m-1||j>n-1||visited[i][j]==1||grid[i][j]==0){
            return;
        }
        visited[i][j]=1;
        move(grid,visited,i-1,j);
        move(grid,visited,i,j+1);
        move(grid,visited,i+1,j);
        move(grid,visited,i,j-1);
    }
    public int numEnclaves(int[][] grid) {
        int m=grid.length;     
        int n=grid[0].length;    
        int[][] visited=new int[m][n];
        for(int i=0;i<m;i++){
            if(visited[i][0]==0&&grid[i][0]==1){
                move(grid,visited,i,0);
            }
             if(visited[i][n-1]==0&&grid[i][n-1]==1){
                move(grid,visited,i,n-1);
            }
        }
        for(int i=0;i<n;i++){
            if(visited[0][i]==0&&grid[0][i]==1){
                move(grid,visited,0,i);
            }
             if(visited[m-1][i]==0&&grid[m-1][i]==1){
                move(grid,visited,m-1,i);
            }
        }
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==0&&grid[i][j]==1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}