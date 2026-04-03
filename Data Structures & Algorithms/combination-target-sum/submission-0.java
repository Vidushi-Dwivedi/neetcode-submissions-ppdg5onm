class Solution {
    Set<List<Integer>> set = new HashSet<List<Integer>>();

    public void helper(int[] nums, int i, int target, List<Integer> lst, List<List<Integer>> ans){
        if(target < 0 || i >= nums.length){
            return;
        }

        if(target == 0 ){
            if(!set.contains(lst)){
                ans.add(new ArrayList(lst));
                set.add(new ArrayList(lst));
            }
            return;
        }

        lst.add(nums[i]);
        helper(nums, i, target - nums[i], lst, ans);
        helper(nums, i + 1, target - nums[i], lst, ans);
        lst.remove(lst.size() - 1);
        helper(nums, i + 1, target, lst, ans);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> lst = new ArrayList<Integer>();

        // for(int i = 0; i < nums.length - 1; i++){
            helper(nums, 0, target, lst, ans);
        // }

        return ans;
    }
}
