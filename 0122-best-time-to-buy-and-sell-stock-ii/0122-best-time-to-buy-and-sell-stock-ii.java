class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int maxProfit = 0;
        int i=0;
        int j = i+1;
        while(j < prices.length){
            if(prices[j] > prices[i]){
                max = prices[j] - prices[i];
                maxProfit += max;
            }
            i++;
            j++;
        }
        return maxProfit;        
    }
}