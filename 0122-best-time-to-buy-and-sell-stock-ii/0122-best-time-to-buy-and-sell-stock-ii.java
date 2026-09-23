class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int i = 1;
        while(i < prices.length){
            if(prices[i] > prices[i-1]){
                maxProfit += prices[i] - prices[i-1];
            }
            i++;
        }
        return maxProfit;
    }
}