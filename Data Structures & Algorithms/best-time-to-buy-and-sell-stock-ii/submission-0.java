class Solution {
    public int opt(int[] prices) {
        int n = prices.length;
        int[] next = new int[2];

        for (int i = n - 1; i >= 0; i--) {
            int[] curr = new int[2];
            for (int j = 0; j <= 1; j++) {
                int include = 0, exclude = 0;
                if (j == 1) {
                    include = (prices[i] * -1) + next[0];
                    exclude = next[1];
                } else {
                    include = prices[i] + next[1];
                    exclude = next[0];
                }

                curr[j] = Math.max(include, exclude);
            }
            next = curr;
        }

        return next[1];
    }

    public int tab(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                int include = 0, exclude = 0;
                if (j == 1) {
                    include = (prices[i] * -1) + dp[i + 1][0];
                    exclude = dp[i + 1][1];
                } else {
                    include = prices[i] + dp[i + 1][1];
                    exclude = dp[i + 1][0];
                }

                dp[i][j] = Math.max(include, exclude);
            }
        }

        return dp[0][1];
    }

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
            include = prices[i] + memo(prices, i + 1, 1, dp);
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
            include = prices[i] + helper(prices, i + 1, !buy);
            exclude = helper(prices, i + 1, buy);
        }

        profit = Math.max(include, exclude);

        return profit;
    }

    public int maxProfit(int[] prices) {
        // return helper(prices, 0, true);

        // int[][] dp = new int[prices.length][2];

        // for (int i = 0; i < dp.length; i++) {
        //     Arrays.fill(dp[i], -1);
        // }

        // return memo(prices, 0, 1, dp);
        // return tab(prices);
        return opt(prices);
    }
}