class Pair{
    int r;
    int c;
    Pair(int r,int c){
        this.r=r;
        this.c=c;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length,n=image[0].length;
        int[][] visited=new int[m][n];
        visited[sr][sc]=1;
        if(image[sr][sc]==color)return image;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(sr,sc));
        int startcol=image[sr][sc];
        image[sr][sc]=color;
        int[] drow={-1,0,+1,0};
        int[] dcol={0,+1,0,-1};
        while(!q.isEmpty()){
            int r=q.peek().r;
            int c=q.peek().c;
            q.poll();
            for(int i=0;i<4;i++){
                int nrow=r+drow[i];
                int ncol=c+dcol[i];
                if(nrow>=0&& nrow<=m-1 && ncol>=0&& ncol<=n-1
                && visited[nrow][ncol]==0 && image[nrow][ncol]==startcol){
                    visited[nrow][ncol]=1;
                    image[nrow][ncol]=color;
                    q.offer(new Pair(nrow,ncol));
                }
            }
        }
        return image;
    }
}