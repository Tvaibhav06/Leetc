class Solution {
    public boolean recur(int[] nums, int i, int sum, int[][] dp) {
        if (sum == 0)
            return true;
        if (i == 0) {
            return nums[0] == sum;
        }
        if (dp[i][sum] != -1) {
            if (dp[i][sum] == 0)
                return false;
            else
                return true;
        }
        boolean t1 = false;
        if (sum >= nums[i])
            t1 = recur(nums, i - 1, sum - nums[i], dp);
        boolean t2 = recur(nums, i - 1, sum, dp);
        if (t1 || t2 == true)
            dp[i][sum] = 1;
        else
            dp[i][sum] = 0;
        return t1 || t2;
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n == 1)return false;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1)return false;
        boolean[][] dp = new boolean[n][sum/2 + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= sum/2)dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum/2; j++) {
                boolean t1 = false;
                if (j >= nums[i])t1=dp[i-1][j-nums[i]];
                boolean t2 = dp[i-1][j];
                dp[i][j]=t1||t2;
            }
        }
        return dp[n-1][sum/2];
    }
}