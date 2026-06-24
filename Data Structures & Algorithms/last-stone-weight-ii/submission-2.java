class Solution {
    public int opt(int[] stones, int target){
        int[] prev = new int[target + 1];

        for(int sum = 0; sum <= target; sum++){
            prev[sum] = Math.abs(target - 2 * sum);
        }

        for(int i = stones.length - 1; i >= 0; i--){
            int[] cur = new int[target + 1];
            for(int sum = 0; sum <= target; sum++){
                int inc = (sum + stones[i] <= target)?
                                prev[sum + stones[i]] : 0 ;
                int exc = prev[sum];

                cur[sum] = Math.min(inc, exc);
            }

            prev = cur;
        }

        return prev[0];
    }

    public int tab(int[] stones, int target){
        int[][] dp = new int[stones.length + 1][target + 1];

        for(int sum = 0; sum <= target; sum++){
            dp[stones.length][sum] = Math.abs(target - 2 * sum);
        }

        for(int i = stones.length - 1; i >= 0; i--){
            for(int sum = 0; sum <= target; sum++){
                int inc = (sum + stones[i] <= target)?
                                dp[i+1][sum + stones[i]] : 0 ;
                int exc = dp[i + 1][sum];

                dp[i][sum] = Math.min(inc, exc);
            }
        }

        return dp[0][0];
    }
    public int memo(int[] stones, int target, int i, int sum, int[][] dp){
        if(i == stones.length){
            return Math.abs(target - 2 * sum);
        }

        if(dp[i][sum] != -1){
            return dp[i][sum];
        }

        int inc = memo(stones, target, i + 1, sum + stones[i], dp);
        int exc = memo(stones, target, i + 1, sum, dp);

        return dp[i][sum] = Math.min(inc, exc);
    }

    public int helper(int[] stones, int target, int i, int sum){
        if(i == stones.length){
            return Math.abs(target - 2* sum);
        }

        int inc = helper(stones, target, i + 1, sum + stones[i]);
        int exc = helper(stones, target, i + 1, sum);

        return Math.min(inc, exc);
    }

    public int lastStoneWeightII(int[] stones) {
        int target = Arrays.stream(stones).sum();

        // return helper(stones, target, 0, 0);
        // int[][] dp = new int[stones.length][target];

        // for(int i = 0; i < stones.length; i++){
        //     Arrays.fill(dp[i], -1);
        // }

        // return memo(stones, target, 0, 0, dp);

        // return tab(stones, target);
        return opt(stones, target);
    }
}