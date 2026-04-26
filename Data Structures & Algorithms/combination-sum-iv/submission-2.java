class Solution {
    public int memo(int[] nums, int target, int[] dp){
        if(target < 0){
            return 0;
        }

        if(dp[target] == -1){
            dp[target] = 0;
            
            for(int j = 0; j < nums.length; j++){
                dp[target] = dp[target] + memo(nums, target-nums[j], dp);
            }
        }

        return dp[target];
    }
    public int helper(int[] nums, int target){
        if(target < 0){
            return 0;
        }
        if(target == 0){
            return 1;
        }

        int ans = 0;
        for(int j = 0; j < nums.length; j++){
            ans = ans + helper(nums, target-nums[j]);
        }

        return ans;
    }
    public int combinationSum4(int[] nums, int target) {
        // return helper(nums, target);

        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;

        return memo(nums, target, dp);
    }
}