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
        if(n==1)return nums[0];
        int prev=nums[0];
        int prev1=0;
        for(int i=1;i<n;i++){
            int take=nums[i];if(i>1)take+=prev1;
            int nottake=prev;
            int curr=Math.max(take,nottake);
            prev1=prev;
            prev=curr;
        }
        return prev;
    }
}