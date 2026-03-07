class Solution {
    public int recur(int i,int[] dp){
       if(i<0)return 0;
       else{
            if(i==0)return 1;
            else if(dp[i-1]!=-1)return dp[i-1];
       }
       return dp[i-1]=(recur(i-1,dp)+recur(i-2,dp));
    }
    public int climbStairs(int n) {
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        int ans=recur(n,dp);
        return dp[n-1];
    }
}