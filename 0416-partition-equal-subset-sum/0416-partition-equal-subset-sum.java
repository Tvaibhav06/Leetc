class Solution {
    static Boolean checksum(int[] arr,int sum,int i,int[][] dp){
        if(sum==0)return true;
        if(i==0){
            return arr[0]==sum;
        }
        if(dp[i][sum]!=-1)return dp[i][sum]==1;
        boolean nottake=checksum(arr,sum,i-1,dp);
        boolean take=false;
        if(sum>=arr[i]){ 
            take=checksum(arr,sum-arr[i],i-1,dp);
        }
        dp[i][sum] = (nottake || take) ? 1 : 0;
        return (nottake||take);
    }
    public boolean canPartition(int[] nums) {
        int n=nums.length,sum=0;
        for(int i=0;i<n;i++)sum+=nums[i];
        if(sum%2==1)return false;
        int[][] dp=new int[n][sum+1];
         for(int[] rows:dp){
            Arrays.fill(rows,-1);
        }
        return checksum(nums,sum/2,n-1,dp);
    }
}