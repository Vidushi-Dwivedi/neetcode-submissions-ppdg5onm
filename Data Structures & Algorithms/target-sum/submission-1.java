class Solution {
    public int tab(int[] nums, int target, int offset){
        int cols = 2 * offset;
        int[][] dp = new int[nums.length + 1][cols + 1];

        dp[nums.length][target + offset] = 1;

        for(int i = nums.length - 1; i>=0; i--){
            for(int sum = -1 * offset; sum <= offset; sum++){
                int sumIndex = sum + offset;

                int pos = (sumIndex + nums[i] <= cols)? 
                                    dp[i + 1][sumIndex + nums[i]] : 0;
                int neg = (sumIndex - nums[i] >= 0)?
                                    dp[i + 1][sumIndex - nums[i]] : 0;

                dp[i][sumIndex] = pos + neg;
            }
        }

        return dp[0][offset];
    }
    public int memo(int[] nums, int target, int i, int sum, int[][] dp, int offset){
        if (i == nums.length) {
            return (sum == target) ? 1 : 0;
        }

        int relativeSumIndex = sum + offset;

        if(dp[i][relativeSumIndex] != -1) {
            return dp[i][relativeSumIndex];
        }

        int pos = memo(nums, target, i + 1, sum + nums[i], dp, offset);
        int neg = memo(nums, target, i + 1, sum - nums[i], dp, offset);

        return dp[i][relativeSumIndex] = pos + neg;
    }

    public int helper(int[] nums, int target, int i, int sum){
        if(nums.length == i){
            if(target == sum){
                return 1;
            } else{
                return 0;
            }
        }

        int pos = helper(nums, target, i + 1, sum + nums[i]);
        int neg = helper(nums, target, i + 1, sum - nums[i]);

        return pos + neg;
    }
    public int findTargetSumWays(int[] nums, int target) {
        // return helper(nums, target, 0, 0);
        int offset = Arrays.stream(nums).sum();
        if(Math.abs(target) > Math.abs(offset)) { return 0; }

        // int[][] dp = new int[nums.length][(2 * offset) + 1];
        // for(int i = 0; i< nums.length; i++){
        //     Arrays.fill(dp[i], -1);
        // }

        // return memo(nums, target, 0, 0, dp, offset);
        return tab(nums, target, offset);
    }
}