class Solution {
    public int memo(String t1, String t2, int i, int j, int[][] dp) {
        if (i >= t1.length() || j >= t2.length()) {
            return 0;
        }
        
        if (dp[i][j] == -1) {
            if (t1.charAt(i) == t2.charAt(j)) {
                return dp[i][j] = 1 + memo(t1, t2, i + 1, j + 1, dp);
            }

            int a = memo(t1, t2, i + 1, j, dp);
            int b = memo(t1, t2, i, j + 1, dp);

            dp[i][j] = Math.max(a, b);
        }

        return dp[i][j];
    }

    public int helper(String t1, String t2, int i, int j) {
        if (i >= t1.length() || j >= t2.length()) {
            return 0;
        }

        if (t1.charAt(i) == t2.charAt(j)) {
            return 1 + helper(t1, t2, i + 1, j + 1);
        }

        int a = helper(t1, t2, i + 1, j);
        int b = helper(t1, t2, i, j + 1);

        return Math.max(a, b);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        // return helper(text1, text2, 0, 0);

        int[][] dp = new int[text1.length()][text2.length()];

        for (int i = 0; i < text1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        return memo(text1, text2, 0, 0, dp);
    }
}
