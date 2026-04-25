class Solution {
    public int tab(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];

        // Arrays.fill(dp, 0);

        dp[len] = 1;
        dp[len - 1] = (s.charAt(len - 1) == '0') ? 0 : 1;

        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
                if (i + 1 < len
                    && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))) {
                    dp[i] += dp[i + 2];
                }
            }
        }

        return dp[0];
    }
    public int helper(String s, int i) {
        int l = s.length();
        if (i == l) {
            return 1;
        }

        char ch = s.charAt(i);
        if (ch == '0') {
            return 0;
        }

        int res = helper(s, i + 1);
        if (i < l - 1 && (ch == '1' || (ch == '2' && s.charAt(i + 1) < '7'))) {
            res = res + helper(s, i + 2);
        }

        return res;
    }

    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }

        // return helper(s, 0);
        return tab(s);
    }
}
