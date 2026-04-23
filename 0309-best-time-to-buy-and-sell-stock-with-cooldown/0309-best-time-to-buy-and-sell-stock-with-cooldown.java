class Solution {
    public int recur(int[] prices,int ind,int buy,int[][] dp){
        if(ind==prices.length){
            return 0;
        }
        if(dp[ind][buy]!=-1)return dp[ind][buy];
        int profit=0;
        if(buy!=0){
            profit=Math.max(-prices[ind]+recur(prices,ind+1,0,dp),recur(prices,ind+1,1,dp));
        }
        else{
            int sell=0;
            if(ind<prices.length-1)sell=prices[ind]+recur(prices,ind+2,1,dp);
            else sell=prices[ind]+recur(prices,ind+1,1,dp);
            profit=Math.max(sell,recur(prices,ind+1,0,dp));
        }
        dp[ind][buy]=profit;
        return dp[ind][buy];
        //return profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return recur(prices,0,1,dp);
    }
}