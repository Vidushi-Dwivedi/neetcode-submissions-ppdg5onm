class Solution {
    public int memo(int amount, int[] coins, int i, int[][] dp){
        if(amount == 0){
            return 1;
        } 
        if(i>= coins.length || amount < 0){
            return 0;
        }

        if(dp[amount][i] != -1){
            return dp[amount][i];
        }

        int include = memo(amount - coins[i], coins, i, dp);
        int exclude = memo(amount, coins, i + 1, dp);
        dp[amount][i] = include + exclude;

        return dp[amount][i];
    }

    public int helper(int amount, int[] coins, int i){
        if(amount == 0){
            return 1;
        } 
        if(i>= coins.length || amount < 0){
            return 0;
        }

        int ways = 0;
        int include = helper(amount - coins[i], coins, i);
        int exclude = helper(amount, coins, i + 1);
        ways += include + exclude;

        return ways;
    }
    public int change(int amount, int[] coins) {
        // return helper(amount, coins, 0);
        int[][] dp = new int[amount + 1][coins.length];

        for(int i = 0; i<= amount; i++){
            Arrays.fill(dp[i], -1);
        }

        return memo(amount, coins, 0, dp);
    }
}
