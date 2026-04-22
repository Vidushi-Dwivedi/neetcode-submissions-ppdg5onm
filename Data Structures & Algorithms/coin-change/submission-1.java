class Solution {
    public int helper(int[] coins, int amount){
        if(amount == 0){
            return 0;
        } 
        if(amount < 0){
            return Integer.MAX_VALUE;
        }

        int min = Integer.MAX_VALUE;

        for(int i = 0; i< coins.length; i++){
            int ans = helper(coins, amount - coins[i]);
            
            if(ans != Integer.MAX_VALUE){
                min = Math.min(min, 1 + ans);
            }
        }

        return min;
    }

    public int tab(int[] coins, int amount){
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int i = 1; i< dp.length; i++){
            for(int j = 0; j<coins.length; j++){
                if(i - coins[j] >= 0){
                    int res = dp[i - coins[j]];
                    // System.out.println(coins[j]);
                    // System.out.println(i+" " + res);

                    if(res != Integer.MAX_VALUE){
                        dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                    }
                }
            }
        }

        return (dp[amount]!= Integer.MAX_VALUE)? dp[amount]: -1;
    }
    // public int memo(int[] coins, int amount, int i, int[] dp){
    //     if(sum == 0){
    //         return 1;
    //     }

    //     if(dp[i] != -1){
    //         return dp[i];
    //     }

    //     for(int j = i; j>=0; j--){
    //         if(sum < coins[i]){
    //             continue;
    //         }

    //         int inc = memo(coins, amount - coins[i], )
    //     }
    // }
    public int coinChange(int[] coins, int amount) {
        // int ans = helper(coins, amount);

        // System.out.println(ans);

        // return ((ans != Integer.MAX_VALUE)? ans: -1);
        return tab(coins, amount);
    }
}
