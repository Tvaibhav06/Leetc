class Solution {
    public int jump(int[] nums, int i, int[] dp) {
        int n = nums.length;
        if (i >= n - 2)
            return nums[i];
        if (dp[i] != -1)
            return dp[i];
        int sum = nums[i], max = Integer.MIN_VALUE;
        for (int j = i + 2; j < n; j++) {
            int jump = jump(nums, j, dp);
            max = Math.max(max, jump);
        }
        sum += max;
        dp[i] = sum;
        return dp[i];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = nums[0];
        if (n == 1)
            return nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < n; i++) {
            int max = Integer.MIN_VALUE;

            for (int j = 0; j <= i - 2; j++) {
                int jump = nums[i];
                int prev = dp[j];
                max = Math.max(max, jump + prev);
            }
            dp[i] = max;
        }
        return Math.max(dp[n - 2], dp[n - 1]);
    }
}