class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxLinear = nums[0], currentMax = 0;
        int minLinear = nums[0], currentMin = 0;
        
        for (int n : nums) {
            totalSum += n;
            currentMax = Math.max(n, currentMax + n);
            maxLinear = Math.max(maxLinear, currentMax);
            
            currentMin = Math.min(n, currentMin + n);
            minLinear = Math.min(minLinear, currentMin);
        }
        
        // If all elements are negative, return the largest single negative element
        return maxLinear < 0 ? maxLinear : Math.max(maxLinear, totalSum - minLinear);
    }
}