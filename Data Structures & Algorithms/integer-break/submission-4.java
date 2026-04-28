class Solution {
    public int memo(int n, int[] dp){
        if(n == 0){
            return 1;
        } 
        if(n == 1){
            return 1;
        }

        if(dp[n] == 0){
            int max = Integer.MIN_VALUE;
            for(int i = 1; i < n; i++){
                int breakFurther = i * memo(n - i, dp);
                int notBreakFurther = i * (n - i);

                max = Math.max(max, Math.max(breakFurther, notBreakFurther));
            }
            dp[n] = max;
        }

        return dp[n];
    }

    public int helper(int n){
        if(n == 0){
            return 1;
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            if(n - i >= 0){
                max = Math.max(max, i * helper(n - i));
            }
        }

        return max;
    }
    public int integerBreak(int n) {
        // return helper(n);
        int[] dp = new int[n + 1];
        return memo(n, dp);
    }
}