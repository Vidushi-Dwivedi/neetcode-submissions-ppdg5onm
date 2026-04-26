class Solution {
    public int tab(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int k = 1; k <= n; k++) {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i * i <= k; i++) {
                if(k- (i*i) >= 0){
                    int ps = 1 + dp[k - (i * i)];
                    min = Math.min(min, ps);
                }
            }
            dp[k] = min;
        }

        return dp[n];
    }
    public int helper(int n) {
        if (n == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int ps = 1 + helper(n - (i * i));
            min = Math.min(min, ps);
        }

        return min;
    }
    public int numSquares(int n) {
        return tab(n);
    }
}