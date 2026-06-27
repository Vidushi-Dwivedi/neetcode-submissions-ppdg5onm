class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min_len = Integer.MAX_VALUE;
        int l = 0, r = 0, sum =0;

        while(r < nums.length){
            sum = sum + nums[r];

            while(sum >= target){
                min_len = Math.min(min_len, r - l + 1);
                sum = sum - nums[l++];
            }

            r++;
        }

        return (min_len != Integer.MAX_VALUE)? min_len : 0;
    }
}