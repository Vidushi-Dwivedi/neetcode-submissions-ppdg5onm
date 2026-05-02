class Solution {
    public int memo(int[] nums, int target, int sum, int i, int[][] dp){
        if(i == nums.length){
            if(target == sum){
                return 1;
            } else{
                return 0;
            }
        }

        if(dp[sum][i] != -1){
            return dp[sum][i];
        }

        int add = memo(nums, target, sum + nums[i], i + 1, dp);
        int sub = memo(nums, target, sum - nums[i], i + 1, dp);

        return dp[sum][i] = add + sub;
    }

    public int helper(int[] nums, int target, int sum, int i){
        if(i == nums.length){
            if(target == sum){
                return 1;
            } else{
                return 0;
            }
        }

        //Add num at index i as +ve
        int add = helper(nums, target, sum + nums[i], i + 1);
        int sub = helper(nums, target, sum - nums[i], i + 1);

        return add + sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, 0, 0);

        // int[][] dp = new int[target + 1][nums.length];

        // for(int i = 0; i<= target; i++){
        //     Arrays.fill(dp[i], -1);
        // }

        // return memo(nums, target, 0, 0, dp);
    }
}
