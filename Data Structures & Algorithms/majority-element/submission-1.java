class Solution {
    public int majorityElement(int[] nums) {
        int x = nums[0];
        int count  = 1;

        for(int i = 1; i< nums.length; i++){
            int n = nums[i];
            
            if(n == x){
                count++;
            } else{
                count--;
            }

            if(count == 0){
                count = 1;
                x = n;
            }
        }

        return x;
    }
}