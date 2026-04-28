class Solution {
    public int firstMissingPositive(int[] nums) {
        int ans = nums.length + 1;
        // System.out.println(ans);

        int  i = 0;
        for(int x: nums){
            if(x <= 0 || x > ans){
                nums[i] = ans;
            }
            // System.out.print(nums[i] + ", ");
            i++;
        }

        for(int x : nums){
            if(x != ans && x != ans * -1){
                // System.out.println(x);
                int abs  = Math.abs(x);
                if(nums[abs - 1] > 0){
                    nums[abs - 1] = nums[abs - 1] * -1;
                }
            }
        }

        for(int j = 0; j< ans - 1; j++){
            if(nums[j] > 0){
                return j + 1;
            }
        }

        return ans;
    }
}