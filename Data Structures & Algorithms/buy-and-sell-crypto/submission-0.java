class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1){ return 0;}

        int purchase_val = prices[0];
        int max_profit = 0;

        for(int i = 1; i<= prices.length - 1; i++){
            if(prices[i] < purchase_val){
                purchase_val = prices[i];
                continue;
            }

            max_profit = Math.max(max_profit, prices[i] - purchase_val);
        }

        return max_profit;
    }
}
