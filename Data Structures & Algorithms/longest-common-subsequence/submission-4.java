class Solution {
    public int opt(String text1, String text2){
        int len1 = text1.length();
        int len2 = text2.length();
        int[] next = new int[len2 + 1];

        for(int i = len1 - 1; i >= 0; i--){
            int[] dp = new int[len2 + 1];
            for(int j = len2 - 1; j >= 0; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[j]= 1 + next[j+1];
                    continue;
                }

                dp[j] = Math.max(next[j], dp[j+1]);
            }
            next = dp;
        }

        return next[0];
    }

    public int tab(String text1, String text2){
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for(int i = len1 - 1; i >= 0; i--){
            for(int j = len2 - 1; j >= 0; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j]= 1 + dp[i+1][j+1];
                    continue;
                }

                dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }

        return dp[0][0];
    }
    public int memo(String text1, String text2, int i, int j, int[][] dp){
        if(i >= text1.length() || j >= text2.length()){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(text1.charAt(i) == text2.charAt(j)){
            return 1 + memo(text1, text2, i + 1, j + 1, dp);
        }

        int l1 = memo(text1, text2, i + 1, j, dp);
        int l2 = memo(text1, text2, i, j + 1, dp);
        return dp[i][j] = Math.max(l1, l2);
    }

    public int helper(String text1, String text2, int i, int j){
        if(i >= text1.length() || j >= text2.length()){
            return 0;
        }

        if(text1.charAt(i) == text2.charAt(j)){
            return 1 + helper(text1, text2, i + 1, j + 1);
        }

        int l1 = helper(text1, text2, i + 1, j);
        int l2 = helper(text1, text2, i, j + 1);
        return Math.max(l1, l2);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        // return helper(text1, text2, 0, 0);

        // int len1 = text1.length();
        // int len2 = text2.length();
        // int[][] dp = new int[len1][len2];

        // for(int i = 0; i< len1; i++){
        //     Arrays.fill(dp[i], -1);
        // }

        // return memo(text1, text2, 0, 0, dp);

        // return tab(text1, text2);
        return opt(text1, text2);
    }
}