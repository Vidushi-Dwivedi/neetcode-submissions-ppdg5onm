class Solution {
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] ans  = new int[len + len];

        for(int i = 0; i< len;i++){
            ans[i] = nums[i];
            ans[len + i] =nums[i];
        }

        return ans;
    }
}