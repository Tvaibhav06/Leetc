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
        int[] dp=new int[n];
        int max=0;
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
               if(nums[j]<nums[i]){
                 dp[i]=Math.max(dp[i],1+dp[j]);
               }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}