class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
       HashSet<Integer> window = new HashSet<>();
       for(int i = 0; i< nums.length; i++){
        if(!window.add(nums[i])) return true;

        if(i >= k){
            window.remove(nums[i - k]);
        }
       }

       return false;
    }
}