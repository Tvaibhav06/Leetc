class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][3];
        for(int i=0;i<3;i++){
            dp[n][0][i]=dp[n][1][i]=0;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<2;j++){
                for(int k=0;k<3;k++){
                    int profit=0;
                    if(j==1){
                        profit=Math.max(dp[i+1][0][k]-prices[i],dp[i+1][1][k]);
                    }
                    else{
                        int sell=0;
                        if(k<2)sell=dp[i+1][1][k+1]+prices[i];
                        profit=Math.max(sell,dp[i+1][0][k]);
                    }
                    dp[i][j][k]=profit;
                }
            }
        }
        return Math.max(dp[0][1][0],Math.max(dp[0][1][1],dp[0][1][2]));
    }
}