class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0, profit = 0;

        for(int i = 1; i < prices.length; i++){
            profit = Math.max(profit, prices[i] - prices[buy]);
            buy = (prices[i] < prices[buy]) ? i: buy;
        }

        return profit;
    }
}
