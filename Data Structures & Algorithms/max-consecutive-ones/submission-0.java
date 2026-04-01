class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = 0; int max_len = 0;
        for(int i: nums){
            if(i == 1){
                len++;
            } else{
                max_len = Math.max(max_len, len);
                len = 0;
            }
        }

        return Math.max(max_len, len);
    }
}