class Solution {
    public int memo(int[] stones, int target, int sum1, int i, int[][] dp){
        if(i == stones.length){
            return Math.abs(target - 2 * sum1);
        }

        if(dp[sum1][i] == -1){
        int include = memo(stones, target, sum1 + stones[i], i + 1, dp);
        int exclude = memo(stones, target, sum1, i + 1, dp);

        dp[sum1][i] = Math.min(include, exclude);
        }

        return dp[sum1][i];
    }
    public int helper(int[] stones, int target, int sum1, int i){
        if(i == stones.length){
            return Math.abs(target - 2 * sum1);
        }

        int include = helper(stones, target, sum1 + stones[i], i + 1);
        int exclude = helper(stones, target, sum1, i + 1);

        return Math.min(include, exclude);
    }

    public int lastStoneWeightII(int[] stones) {
        int total = 0;

        for(int x : stones){
            total += x;
        }

        // return helper(stones, total, 0, 0);
        int[][] dp = new int[total][stones.length];

        for(int i = 0; i< total; i++){
            Arrays.fill(dp[i], -1);
        }

        return memo(stones, total, 0, 0, dp);
    }
}