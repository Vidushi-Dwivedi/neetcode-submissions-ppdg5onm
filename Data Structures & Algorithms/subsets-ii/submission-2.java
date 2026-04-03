class Solution {
    // Set<List<List<Integer>>> set = new HashSet<>();

    public void helper(int[] nums, int i, List<List<Integer>> ans, List<Integer> lst){
        ans.add(new ArrayList(lst));

        for(int j = i; j< nums.length; j++){
            if(j>i && nums[j] == nums[j-1]) continue;

            // helper(nums, j + 1, ans, lst);

            lst.add(nums[j]);
            helper(nums, j + 1, ans, lst);
            lst.remove(lst.size() - 1);
        }       
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> lst = new ArrayList<Integer>();
        Arrays.sort(nums);
        helper(nums, 0, ans, lst);

        return ans;
    }
}
