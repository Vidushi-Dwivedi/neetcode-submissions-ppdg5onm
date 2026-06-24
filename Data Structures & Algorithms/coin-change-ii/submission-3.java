class Solution {
    public int opt(int amount, int[] coins){
        int[] next = new int[amount + 1];
        next[0] = 1;

        for(int i = coins.length - 1; i >=0 ; i--){
            int[] cur = new int[amount + 1];
            cur[0] = 1;

            for(int amt = 0; amt <= amount; amt++ ){
                int inc = (amt-coins[i] >= 0)? 
                            cur[amt - coins[i]] : 0;
                int exc = next[amt];

                cur[amt] = inc + exc; 
            }
            next = cur;
        }

        return next[amount];
    }

    public int tab(int amount, int[] coins){
        int[][] dp = new int[coins.length + 1][amount + 1];

        for(int i = 0; i< coins.length + 1; i++){
            dp[i][0] = 1;
        }

        for(int i = coins.length - 1; i >=0 ; i--){
            for(int amt = 0; amt <= amount; amt++ ){
                int inc = (amt-coins[i] >= 0)? 
                            dp[i][amt - coins[i]] : 0;
                int exc = dp[i + 1][amt];

                dp[i][amt] = inc + exc; 
            }
        }

        return dp[0][amount];
    }
    public int memo(int amount, int[] coins, int i, int[][] dp){
        if(amount == 0){
            return 1;
        }

        if(amount < 0 || i >= coins.length){
            return 0;
        }

        if(dp[i][amount] != -1){
            return dp[i][amount];
        }

        int inc = memo(amount - coins[i], coins, i, dp);
        int exc = memo(amount, coins, i + 1, dp);

        return dp[i][amount] = inc + exc;
    }

    public int helper(int amount, int[] coins, int i){
        if(amount == 0){
            return 1;
        }

        if(amount < 0 || i >= coins.length){
            return 0;
        }

        int inc = helper(amount - coins[i], coins, i);
        int exc = helper(amount, coins, i + 1);

        return inc + exc;
    }
    public int change(int amount, int[] coins) {
        // return helper(amount, coins, 0);

        // int[][] dp = new int[coins.length][amount + 1];

        // for(int i = 0; i< coins.length; i++){
        //     Arrays.fill(dp[i], -1);
        // }

        // return memo(amount, coins, 0, dp);

        // return tab(amount, coins);
        return opt(amount, coins);
    }
}