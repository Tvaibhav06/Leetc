class Solution {
    public int recur(int[] nums,int i,int[] dp){
        if(i==0)return nums[0];
        if(i<0)return 0;
        if(dp[i]!=-1)return dp[i];
        int take=nums[i]+recur(nums,i-2,dp);
        int nottake=recur(nums,i-1,dp);
        dp[i]=Math.max(take,nottake);
        return dp[i];
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return recur(nums,n-1,dp);
    }
}