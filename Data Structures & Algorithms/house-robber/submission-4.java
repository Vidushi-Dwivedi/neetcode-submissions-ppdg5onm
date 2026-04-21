class Solution {
    public int memo(int[] nums, int n, int[] dp){
        System.out.println(n);
        if(n < 0){ return 0;}
        if(n==0){ return nums[0]; }
        
        if(dp[n] == -1){
            int inc = memo(nums, n - 2, dp) + nums[n];
            int exc = memo(nums, n-1, dp);
            dp[n] = Math.max(inc, exc);
        }

        return dp[n];
    }
    // public tab(int[] nums){
    //     int n = nums.length;

    // }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return memo(nums, n - 1, dp);

        // return dp[n - 1];
    }
}
