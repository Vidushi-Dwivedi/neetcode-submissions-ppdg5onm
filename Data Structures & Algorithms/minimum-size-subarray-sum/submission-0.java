class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, minLen = Integer.MAX_VALUE;
        for(int right = 0; right< nums.length; right++){
            sum = sum + nums[right];
            System.out.println("sum = " + sum + " right = " + right);
            while(sum >= target){
                System.out.println("Inside: left = "+ left);
                minLen = Math.min(minLen, right-left + 1);
                sum = sum - nums[left];
                left++;
            }
        }

        return (minLen != Integer.MAX_VALUE)? minLen: 0;
    }
}