class Solution {
    public int helper(int n, int[] dp){
        if(n < 0){
            return 0;
        }

        if(dp[n] == 0){
            dp[n] = helper(n-1, dp) + helper(n-2, dp);
        }
        
        return dp[n];
    }

    public int helper2(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i<n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public int climbStairs(int n) {
        // int[] dp = new int[n+1];
        // dp[0] = 1;

        // return helper(n, dp);
        return helper2(n);
    }
}
