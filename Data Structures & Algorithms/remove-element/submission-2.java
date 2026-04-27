class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if(n == 0 || (n == 1 && nums[0] == val)){
            return 0;
        }

        int i = 0;
        int k = n-1;

        while(k >=0 && nums[k] == val){ k--;}

        while(i <= k){
            if(nums[i] == val){
                nums[i] = nums[k];
                i++;
                k--;
                while(k >=0 && nums[k] == val){ k--;}
            } else{
                i++;
            }
        }

        return k + 1;
    }
}