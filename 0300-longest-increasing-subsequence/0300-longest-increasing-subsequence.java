class Solution {
    public int recur(int[] nums,int ind,int prev_ind,int[][] dp){
        if(ind==nums.length)return 0;
        if(dp[ind][prev_ind+1]!=-1)return dp[ind][prev_ind+1];
        int take=0,nottake=0;
        if(prev_ind==-1||nums[prev_ind]<nums[ind])take=1+recur(nums,ind+1,ind,dp);
        nottake=recur(nums,ind+1,prev_ind,dp);
        return dp[ind][prev_ind+1]=Math.max(take,nottake);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n+1][n+1];
        for(int i=n-1;i>=0;i--){
            for(int j=i-1;j>=-1;j--){
                int take=0,nottake=dp[i+1][j+1];
                if(j==-1||nums[j]<nums[i])take=1+dp[i+1][i+1];
                dp[i][j+1]=Math.max(take,nottake);
            }
        }
        return dp[0][0];
    }
}