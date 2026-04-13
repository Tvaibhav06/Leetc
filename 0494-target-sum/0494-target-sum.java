class Solution {
    public int recur(int[] nums, int target, int i, int sum, int[][] dp,int total) {
        int j = sum;
        if (j < 0)j = Math.abs(sum) +total;
        if (i == 0) {
            if (nums[0] == 0 && sum == target){
                dp[0][j] = 2;
                return 2;
            }
            if (sum + nums[0] == target || sum - nums[0] == target) {
                dp[0][j] = 1;
                return 1;
            } else {
                dp[0][j] = 0;
                return 0;
            }
        }
        if (dp[i][j] != -1)return dp[i][j];
        int takepos = 0;
        int takeneg = 0;
        takepos += recur(nums, target, i - 1, sum + nums[i], dp,total);
        takeneg += recur(nums, target, i - 1, sum - nums[i], dp,total);
        dp[i][j] = takepos + takeneg;
        return dp[i][j];
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, total = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];
        }
        int[][] dp = new int[n][2 * total + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return recur(nums, target, n - 1, 0, dp,total);
    }
}