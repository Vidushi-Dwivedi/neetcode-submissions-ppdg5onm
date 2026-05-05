class Solution {
    public int memo(int[] nums, int i, int j, int[][] dp){
        if(i > j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int max = Integer.MIN_VALUE;
        for(int k = i; k<=j; k++){
            max = Math.max(max, nums[i - 1] * nums[k] * nums[j + 1] +
                    memo(nums, i, k - 1, dp) + memo(nums, k + 1, j, dp));
        }

        return dp[i][j] = max;
    }

    public int helper(int[] nums, int i, int j){
        if(i > j){
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for(int k = i; k<=j; k++){
            max = Math.max(max, nums[i - 1] * nums[k] * nums[j + 1] +
                    helper(nums, i, k - 1) + helper(nums, k + 1, j));
        }

        return max;
    }

    public int maxCoins(int[] nums) {
        int[] nums_copy = new int[nums.length + 2];
        int[][] dp = new int[nums_copy.length + 1][nums_copy.length + 1];
        int n = nums_copy.length;

        for(int i = 0; i< nums.length; i++){
            nums_copy[i + 1] = nums[i];
        }

        nums_copy[0] = 1;
        nums_copy[n - 1] = 1;

        for(int i = 0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }

        // return helper(nums_copy, 1, n - 2);

        return memo(nums_copy, 1, n-2, dp);
    }
}
