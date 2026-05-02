class Solution {
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
            ways = helper(s, t, i + 1, j);
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

        int[][] dp = new int[s.length()][t.length()];

        for(int i = 0; i< s.length(); i++){
            Arrays.fill(dp[i], -1);
        }

        return memo(s, t, 0, 0, dp);
    }
}
