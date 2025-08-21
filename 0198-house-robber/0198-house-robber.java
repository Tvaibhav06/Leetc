class Solution {
    public int jumps(int[] nums,int i,int[] dp){
        if(i>=nums.length)return 0;
        if(dp[i]!=-1)return dp[i];
        int rob=nums[i]+jumps(nums,i+2,dp);
        int skip=jumps(nums,i+1,dp);
        dp[i]=Math.max(skip,rob);
        return dp[i];
    }
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        int f=jumps(nums,0,dp);
        return f;
    }
}