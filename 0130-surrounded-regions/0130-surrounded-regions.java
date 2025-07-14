class Solution {
    public void DFS(char[][] board,int[][] markup,int u,int v){
        int m=board.length;
        int n=board[0].length;
        if(u<0||u>=m||v<0||v>=n||board[u][v]!='O'||markup[u][v]==1)return;
        markup[u][v]=1;
        DFS(board,markup,u-1,v);
        DFS(board,markup,u,v+1);
        DFS(board,markup,u+1,v);
        DFS(board,markup,u,v-1);
    }
    public void fixit(char[][] board,int[][] markup){
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<n;i++){
            if(board[0][i]=='O' && markup[0][i]==0){
                DFS(board,markup,0,i);
            }
            if(board[m-1][i]=='O' && markup[m-1][i]==0){
                DFS(board,markup,m-1,i);
            }
        }
        for(int i=1;i<m-1;i++){
            if(board[i][0]=='O' && markup[i][0]==0){
                DFS(board,markup,i,0);
            }
            if(board[i][n-1]=='O' && markup[i][n-1]==0){
                DFS(board,markup,i,n-1);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(markup[i][j]!=1){
                    board[i][j]='X';
                }
            }
        }
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int[][] markup=new int[m][n];
        fixit(board,markup);
    }
}