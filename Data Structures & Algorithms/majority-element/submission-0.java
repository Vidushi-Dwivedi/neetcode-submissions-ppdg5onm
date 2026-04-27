class Solution {
    public int majorityElement(int[] nums) {
        int x = 0;
        int count  = 0;

        for(int n: nums){
            if(count == 0){
                x = n;
            }
            if(n == x){
                count++;
            } else{
                count--;
            }
        }

        return x;
    }
}