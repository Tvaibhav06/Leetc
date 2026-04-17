class Solution {
    public int maxProfit(int[] prices) {
        int khareeda=prices[0],profit=0;
        for(int i=1;i<prices.length;i++){
            if(khareeda>prices[i]){
                khareeda=prices[i];
            }
            else{
                if(i<prices.length-1 && prices[i+1]>prices[i])continue;
                profit+=prices[i]-khareeda;
                khareeda=Integer.MAX_VALUE;
            } 
        }
        return profit;
    }
}