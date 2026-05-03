class Solution {
    public int tab(int[] nums){
        int n = nums.length;

        int[][] dp = new int[n + 1][n + 1];

        for(int i = n - 1; i >= 0; i--){
            for(int j = i - 1; j >= -1; j--){
                int include = 0;

                if(j == -1 || nums[i] > nums[j]){
                    include = 1 + dp[i + 1][i + 1];    //since prev in dp is j + 1 so we will use i + 1
                }

                int exclude = dp[i + 1][j + 1];

                dp[i][j + 1] = Math.max(include, exclude);
            }
        }

        return dp[0][0];
    }

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

        // int[][] dp = new int[nums.length + 1][nums.length + 1];
        // for(int i = 0; i<= nums.length; i ++){
        //     Arrays.fill(dp[i], -1);
        // }

        // return memo(nums, 0, -1, dp);

        return tab(nums);
    }
}
