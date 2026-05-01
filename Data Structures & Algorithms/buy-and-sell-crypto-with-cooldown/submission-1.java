class Solution {
    public int memo(int[] prices, int i, int buy, int[][] dp) {
        if (i >= prices.length) {
            return 0;
        }

        if (dp[i][buy] != -1) {
            return dp[i][buy];
        }

        int include = 0, exclude = 0;
        if (buy == 1) {
            include = (prices[i] * -1) + memo(prices, i + 1, 0, dp);
            exclude = memo(prices, i + 1, buy, dp);
        } else {
            include = prices[i] + memo(prices, i + 2, 1, dp);
            exclude = memo(prices, i + 1, buy, dp);
        }

        dp[i][buy] = Math.max(include, exclude);

        return dp[i][buy];
    }

    public int helper(int[] prices, int i, Boolean buy) {
        if (i >= prices.length) {
            return 0;
        }

        int profit = 0, include = 0, exclude = 0;
        if (buy) {
            include = (prices[i] * -1) + helper(prices, i + 1, !buy);
            exclude = helper(prices, i + 1, buy);
        } else {
            include = prices[i] + helper(prices, i + 2, !buy);
            exclude = helper(prices, i + 1, buy);
        }

        profit = Math.max(include, exclude);

        return profit;
    }

    public int maxProfit(int[] prices) {
        // return helper(prices, 0, true);

        int[][] dp = new int[prices.length][2];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return memo(prices, 0, 1, dp);
    }
}
