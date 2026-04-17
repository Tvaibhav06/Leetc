class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int buy=prices[0],profit=0;
        for(int i=1;i<n;i++){
            if(buy>prices[i])buy=prices[i];
            profit=(profit<prices[i]-buy)?prices[i]-buy:profit;
        }
        return profit;
    }
}