class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, max = 0, k1 = 0;
        while(r <nums.length){
            if( nums[r] == 1){
                r++;
            } else{
                if(k1 < k){
                    k1++;
                    r++;
                }else{
                    while( k1 >= k){
                        if(nums[l] == 0){
                            k1--;
                        }
                        l++;
                    }
                }
            }

            max = Math.max(max, r-l);
        }

        return max;
    }
}