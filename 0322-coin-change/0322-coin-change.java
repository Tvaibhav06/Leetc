class Solution {
    public int recur(int[] coins, int amount, int i, int[][] dp) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0)
            return -1;
        if (i == 0) {
            int c = 0;
            if (amount % coins[0] == 0) {
                dp[0][amount] = amount / coins[0];
                return amount / coins[0];
            }
            return -1;
        }
        if (dp[i][amount] != -2)
            return dp[i][amount];
        int num = Integer.MAX_VALUE;
        int takesame = 0, take = 0, nottake = 0;
        takesame = recur(coins, amount - coins[i], i, dp);
        if (takesame != -1)
            num = Math.min(takesame + 1, num);
        take = recur(coins, amount - coins[i], i - 1, dp);
        if (take != -1)
            num = Math.min(take + 1, num);
        nottake = recur(coins, amount, i - 1, dp);
        if (nottake != -1)
            num = Math.min(nottake, num);
        if (takesame == -1 && take == -1 && nottake == -1){
            dp[i][amount]=-1;
            return -1;
        }    
        dp[i][amount] = num;
        return dp[i][amount];
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -2);
        }
        int ans = recur(coins, amount, n - 1, dp);
        return ans;
    }
}