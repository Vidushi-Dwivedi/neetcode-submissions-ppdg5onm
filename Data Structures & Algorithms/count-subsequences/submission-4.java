class Solution {
    public int tab(String s, String t){
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0; i<= n; i++){
            dp[i][m] = 1;
        }

        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                int ways = 0;
                if(s.charAt(i) == t.charAt(j)){
                    int include = dp[i + 1][j + 1];
                    int exclude = dp[i + 1][j];
                    ways = include + exclude;
                } else{
                    ways = dp[i + 1][j];
                }

                dp[i][j] = ways;
            }
        }

        return dp[0][0];
    }

    public int memo(String s, String t, int i, int j, int[][] dp){
        if(j == t.length()){
            return 1;
        }
        if(i == s.length()){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ways = 0;
        if(s.charAt(i) == t.charAt(j)){
            int include = memo(s, t, i + 1, j + 1, dp);
            int exclude = memo(s, t, i + 1, j, dp);
            ways = include + exclude;
        } else{
            ways = memo(s, t, i + 1, j, dp);
        }

        return dp[i][j] = ways;
    }

    public int helper(String s, String t, int i, int j){
        if(j == t.length()){
            return 1;
        }
        if(i == s.length()){
            return 0;
        }

        int ways = 0;
        if(s.charAt(i) == t.charAt(j)){
            int include = helper(s, t, i + 1, j + 1);
            int exclude = helper(s, t, i + 1, j);
            ways = include + exclude;
        } else{
            ways = helper(s, t, i + 1, j);
        }

        return ways;
    }

    public int numDistinct(String s, String t) {
        // return helper(s, t, 0, 0);

        // int[][] dp = new int[s.length()][t.length()];

        // for(int i = 0; i< s.length(); i++){
        //     Arrays.fill(dp[i], -1);
        // }

        // return memo(s, t, 0, 0, dp);

        return tab(s, t);
    }
}
