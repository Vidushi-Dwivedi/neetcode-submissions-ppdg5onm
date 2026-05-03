class Solution {
    public int memo(int[] nums, int curr, int prev, int[][] dp){
        if(curr >= nums.length){
            return 0;
        }

        if(dp[curr][prev + 1] != -1){
            return dp[curr][prev + 1];
        }

        int include = 0;
        if(prev == -1 || nums[curr] > nums[prev]){
            include = 1 + memo(nums, curr + 1, curr, dp);
        }

        //Exclude
        int exclude = memo(nums, curr + 1, prev, dp);

        return dp[curr][prev + 1] = Math.max(include, exclude);
    }

    public int helper(int[] nums, int curr, int prev){
        if(curr >= nums.length){
            return 0;
        }

        if(prev != -1 && nums[curr] <= nums[prev]){
            return Integer.MIN_VALUE;
        }

        //Include
        int include = 1 + helper(nums, curr + 1, curr);
        //Exclude
        int exclude = helper(nums, curr + 1, prev);

        return Math.max(include, exclude);
    }

    public int lengthOfLIS(int[] nums) {
        // return helper(nums, 0, -1);

        int[][] dp = new int[nums.length + 1][nums.length + 1];
        for(int i = 0; i<= nums.length; i ++){
            Arrays.fill(dp[i], -1);
        }

        return memo(nums, 0, -1, dp);
    }
}
