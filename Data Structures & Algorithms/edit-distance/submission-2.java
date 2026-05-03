class Solution {
    public int tab(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int j = 0; j <= l2; j++) {
            dp[l1][j] = l2 - j;
        }

        for (int i = 0; i <= l1; i++) {
            dp[i][l2] = l1 - i;
        }

        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    // Insert
                    int oper1 = dp[i][j + 1];
                    // Delete
                    int oper2 = dp[i + 1][j];
                    // Replace
                    int oper3 = dp[i + 1][j + 1];

                    dp[i][j] = 1 + Math.min(oper1, Math.min(oper2, oper3));
                }
            }
        }

        return dp[0][0];
    }

    public int memo(String word1, String word2, int i1, int i2, int[][] dp) {
        if (i1 == word1.length()) {
            return word2.length() - i2;
        }
        if (i2 == word2.length()) {
            return word1.length() - i1;
        }

        if (dp[i1][i2] != -1) {
            return dp[i1][i2];
        }

        if (word1.charAt(i1) == word2.charAt(i2)) {
            return dp[i1][i2] = memo(word1, word2, i1 + 1, i2 + 1, dp);
        }

        // Insert
        int oper1 = memo(word1, word2, i1, i2 + 1, dp);
        // Delete
        int oper2 = memo(word1, word2, i1 + 1, i2, dp);
        // Replace
        int oper3 = memo(word1, word2, i1 + 1, i2 + 1, dp);

        return dp[i1][i2] = 1 + Math.min(oper1, Math.min(oper2, oper3));
    }
    public int helper(String word1, String word2, int i1, int i2) {
        if (i1 == word1.length()) {
            return word2.length() - i2;
        }
        if (i2 == word2.length()) {
            return word1.length() - i1;
        }

        if (word1.charAt(i1) == word2.charAt(i2)) {
            return helper(word1, word2, i1 + 1, i2 + 1);
        }

        // Insert
        int oper1 = helper(word1, word2, i1, i2 + 1);
        // Delete
        int oper2 = helper(word1, word2, i1 + 1, i2);
        // Replace
        int oper3 = helper(word1, word2, i1 + 1, i2 + 1);

        return 1 + Math.min(oper1, Math.min(oper2, oper3));
    }

    public int minDistance(String word1, String word2) {
        // return helper(word1, word2, 0, 0);

        // int[][] dp = new int[word1.length()][word2.length()];

        // for(int i = 0; i< word1.length(); i++){
        //     Arrays.fill(dp[i], -1);
        // }

        // return memo(word1, word2, 0, 0, dp);

        return tab(word1, word2);
    }
}
