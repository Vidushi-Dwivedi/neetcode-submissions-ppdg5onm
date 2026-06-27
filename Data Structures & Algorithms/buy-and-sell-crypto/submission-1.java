class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        int min_price = prices[0];

        for(int i = 0; i< prices.length; i++){
            int price = prices[i];

            if(price < min_price){
                min_price = price;
            }

            max_profit = Math.max(max_profit, (price - min_price));
        }

        return max_profit;
    }
}
