class Solution {
    public void helper(int[] nums, int i, List<List<Integer>> ans, List<Integer> lst){
        if(i >= nums.length){
            ans.add(new ArrayList(lst));
            return;
        }

        //Exclude
        helper(nums, i + 1, ans, lst);
        //Include
        lst.add(nums[i]);
        helper(nums, i + 1, ans, lst);
        lst.remove(lst.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> lst = new ArrayList<Integer>();
        helper(nums, 0, ans, lst);

        return ans;
    }
}
