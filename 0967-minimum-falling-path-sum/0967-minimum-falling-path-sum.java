class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[][] dp=new int[n][n];
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            dp[n-1][i]=matrix[n-1][i];
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                int left=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
                if(j>0) left=matrix[i][j]+dp[i+1][j-1];
                int down=matrix[i][j]+dp[i+1][j];
                if(j<n-1) right=matrix[i][j]+dp[i+1][j+1];
                dp[i][j]=Math.min(left,Math.min(right,down));
            }
        }
        for(int i=0;i<n;i++){
            mini=Math.min(mini,dp[0][i]);
        }
        return mini;
    }
}