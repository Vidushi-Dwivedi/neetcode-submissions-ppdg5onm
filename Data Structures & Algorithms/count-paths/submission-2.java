class Solution {
    public int opt(int m, int n){
        int[] next = new int[m];
        next[m - 1] = 1;

        for(int i = m - 1; i >= 0; i--){
            int[] curr = new int[n];

            for(int j = n - 1; j >= 0; j--){
                if( i == m - 1 && j == n - 1){
                    curr[j] = 1;
                    continue;
                } else{
                    if(i + 1 < m){
                        curr[j] = next[j];
                    }
                    if(j + 1 < n){
                        curr[j] += curr[j + 1];
                    }
                }
            }
            next = curr;
        }

        return next[0];
    }

    public int tab(int m, int n){
        int[][] dp = new int[m][n];

        for(int i = 0; i< dp.length; i++){
            Arrays.fill(dp[i], -1);
        }

        dp[m-1][n-1] = 1;

        for(int i = m - 1; i>=0; i--){
            for(int j = n - 1; j>=0; j--){
                if(dp[i][j] == -1){
                     dp[i][j] = 0;
                    if(i + 1 < m){
                        dp[i][j] = dp[i + 1][j];
                    }
                    if(j + 1 < n){
                        dp[i][j] += dp[i][j + 1];
                    }
                }
            }
        }

        return dp[0][0];
    }
    public int memo(int[][] dp, int i, int j){
        if(i >= dp.length || j >= dp[0].length){
            return 0;
        }

        if(dp[i][j] == -1){
            dp[i][j] = memo(dp, i + 1, j) + memo(dp, i, j + 1);
        }

        return dp[i][j];
    }
    public int helper(int m, int n, int i, int j){
        if(i >= m || j >= n){
            return 0;
        }
        if(i == m - 1 && j == n - 1){
            return 1;
        }

        return helper(m, n, i + 1, j) + helper(m, n, i, j + 1);
    }
    public int uniquePaths(int m, int n) {
        // return helper(m, n, 0, 0);

        // int[][] dp = new int[m][n];

        // for(int i = 0; i< dp.length; i++){
        //     Arrays.fill(dp[i], -1);
        // }

        // dp[m-1][n-1] = 1;
        // return memo(dp, 0, 0);

        // return tab(m, n);
        return opt(m, n);
    }
}
