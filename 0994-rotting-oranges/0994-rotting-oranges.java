class Pair{
    int r,c,w;
    Pair(int r,int c,int w){
        this.r=r;
        this.c=c;
        this.w=w;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] visited=new int[m][n];
        Queue<Pair> q=new LinkedList<>();
        int cntFresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    visited[i][j]=2;
                }
                else if(grid[i][j]==1){
                    visited[i][j]=0;
                    cntFresh++;
                }
                else{
                    visited[i][j]=0;
                }
            }
        }
    int tm=0;
    int drow[]={-1,0,1,0};
    int dcol[]={0,1,0,-1};
    int cnt=0;
    while(!q.isEmpty()){
        int row=q.peek().r;
        int col=q.peek().c;
        int time=q.peek().w;
        tm=Math.max(tm,time);
        q.remove();
        for(int i=0;i<4;i++){
            int nrow=row+drow[i];
            int ncol=col+dcol[i];
            if(nrow>=0&&ncol>=0&& nrow<m && ncol<n && visited[nrow][ncol]==0 && grid[nrow][ncol]==1){
                q.add(new Pair(nrow,ncol,time+1));
                visited[nrow][ncol]=2;
                cnt++;
            }
        }
    }
    if(cnt!= cntFresh)return -1;
    return tm;
    }    
}