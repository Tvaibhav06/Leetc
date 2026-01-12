class pair{
    int r;
    int c;
    public pair(int r,int c){
        this.r=r;
        this.c=c;
    }
}
class Solution {
    public void bfs(int[][] copy,int sr,int sc,int[][] visited,int color,int startcolor){
        int m=copy.length;
        int n=copy[0].length;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(sr,sc));
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        while(!q.isEmpty()){
             int row=q.peek().r;
             int col=q.peek().c;
             q.remove();
             visited[row][col]=1;
             for(int i=0;i<4;i++){
                int nrow=row+drow[i];
                int ncol=col+dcol[i];
                if(nrow>=0&&ncol>=0&&nrow<m&&ncol<n&&visited[nrow][ncol]==0&&copy[nrow][ncol]==startcolor){
                    q.add(new pair(nrow,ncol));
                    visited[nrow][ncol]=1;
                    copy[nrow][ncol]=color;
                }
             }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        int[][] copy=new int[m][n];
        int[][] visited=new int[m][n];
        copy=image;
        int startcolor=copy[sr][sc];
        copy[sr][sc]=color;
        visited[sr][sc]=1;
        bfs(copy,sr,sc,visited,color,startcolor);
        return copy;
    }
}