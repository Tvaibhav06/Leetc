class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[] prev=new int[n];
        int mini=Integer.MAX_VALUE;
        for(int i=n-2;i>=0;i--){
            int[] curr=new int[n];
            for(int j=0;j<n;j++){
                int left=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
                if(j>0) left=matrix[i+1][j-1];
                int down=matrix[i+1][j];
                if(j<n-1) right=matrix[i+1][j+1];
                matrix[i][j]+=Math.min(left,Math.min(right,down));
            }
            prev=curr;
        }
        for(int i=0;i<n;i++){
            mini=Math.min(mini,matrix[0][i]);
        }
        return mini;
    }
}