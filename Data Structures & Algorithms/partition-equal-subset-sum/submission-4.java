class Solution {
    public boolean memo(int[] nums, int i, int target, Boolean[][] dp) {
        if (target == 0) {
            return true;
        }
        if (i >= nums.length || target < 0) {
            return false;
        }

        // System.out.println(i + " , " + target);

        if (dp[i][target] == null) {
            boolean inc = memo(nums, i + 1, target - nums[i], dp);
            boolean exc = memo(nums, i + 1, target, dp);
            dp[i][target] = inc || exc;
        }

        return dp[i][target];
    }

    public boolean helper(int[] nums, int i, int target) {
        if (target == 0) {
            return true;
        }
        if (i >= nums.length || target < 0) {
            return false;
        }

        boolean inc = helper(nums, i + 1, target - nums[i]);
        boolean exc = helper(nums, i + 1, target);

        return (inc || exc);
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int x : nums) {
            sum = sum + x;
        }

        if (sum % 2 != 0) {
            return false;
        }

        // return helper(nums, 0 , sum / 2);

        Boolean[][] dp = new Boolean[nums.length][sum / 2 + 1];

        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], null);
        }
        return memo(nums, 0, sum / 2, dp);
    }
}
