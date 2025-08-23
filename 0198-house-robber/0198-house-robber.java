class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int prev1=nums[0];
        int prev2=0;
        for(int i=1;i<n;i++){
            int pick=nums[i]+prev2;
            int skip=prev1;
            int curr=Math.max(skip,pick);

            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}