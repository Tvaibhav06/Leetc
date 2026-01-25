class Solution {
    public void eliminate(char[][] board,int[][] visited,int i,int j){
        int m=board.length;
        int n=board[0].length;
        if(i<0||i>m-1||j<0||j>n-1||board[i][j]=='X'||visited[i][j]==1){
                return;
        }
        visited[i][j]=1;
        eliminate(board,visited,i-1,j);
        eliminate(board,visited,i,j+1);
        eliminate(board,visited,i+1,j);
        eliminate(board,visited,i,j-1);
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int[][] visited=new int[m][n];
        for(int i=0;i<m;i++){
            if(board[i][0]=='O' && visited[i][0]==0){

                eliminate(board,visited,i,0);
            }
            if(board[i][n-1]=='O' && visited[i][n-1]==0){
                eliminate(board,visited,i,n-1);
            }
        }
        for(int i=0;i<n;i++){
            if(board[0][i]=='O' && visited[0][i]==0){
                eliminate(board,visited,0,i);
            }
            if(board[m-1][i]=='O' && visited[m-1][i]==0){
                eliminate(board,visited,m-1,i);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'&& visited[i][j]==0){
                    board[i][j]='X';
                }
            }
        }
    }
}