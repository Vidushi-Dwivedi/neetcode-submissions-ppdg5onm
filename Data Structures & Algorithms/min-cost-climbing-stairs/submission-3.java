class Solution {
    public int helper(int n, int[] dp, int[] cost){
        if(n < 0){
            return 0;
        }

        if(dp[n] == -1){
            dp[n] = cost[n] + Math.min(helper(n-1, dp, cost), helper(n-2, dp, cost));
        }

        return dp[n];
    }

    public int helper2(int n, int[] cost){
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i<n; i++){
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }

        return Math.min(dp[n-1], dp[n-2]);
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // int[] dp = new int[n];
        // Arrays.fill(dp, -1);

        // dp[0] = cost[0];
        // dp[1] = cost[1];

        // return Math.min(helper(n-1, dp, cost), helper(n-2, dp, cost));

        return helper2(n, cost);
    }
}
