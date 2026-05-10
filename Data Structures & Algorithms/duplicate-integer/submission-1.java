class Solution {
    public boolean hasDuplicate(int[] nums) {
      HashSet<Integer> hs = new HashSet<>();
      int n = nums.length;
      for(int i=0; i<n; i++){
        if(hs.contains(nums[i])){
            return true;
        }
        hs.add(nums[i]);
      }  

      return false;
    }
}