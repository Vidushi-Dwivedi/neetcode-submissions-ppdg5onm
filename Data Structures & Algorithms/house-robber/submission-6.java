class Solution {
    public int memo(int[] nums, int n, int[] dp) {
        System.out.println(n);
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return nums[0];
        }

        if (dp[n] == -1) {
            int inc = memo(nums, n - 2, dp) + nums[n];
            int exc = memo(nums, n - 1, dp);
            dp[n] = Math.max(inc, exc);
        }

        return dp[n];
    }
    public int tab(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        if (n == 1) {
            return nums[0];
        }

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int inc = dp[i - 2] + nums[i];
            int exc = dp[i - 1];
            dp[i] = Math.max(inc, exc);
        }

        return dp[n - 1];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        // int[] dp = new int[n];
        // Arrays.fill(dp, -1);

        // return memo(nums, n - 1, dp);

        // return dp[n - 1];

        // return tab(nums);
        if (n == 1) {
            return nums[0];
        }

        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);

        for(int i = 2; i<n; i++){
            int temp = a + nums[i];
            a = b;
            b = Math.max(a, temp);
        }

        return b;
    }
}
