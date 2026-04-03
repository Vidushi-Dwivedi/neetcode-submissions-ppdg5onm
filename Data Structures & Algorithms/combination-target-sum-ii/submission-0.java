class Solution {
    public void solve(int idx, int[] candidates, int target, 
                      List<Integer> ans, List<List<Integer>> output) {

        if (target == 0) {
            output.add(new ArrayList<>(ans));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {

            // skip duplicates
            if (i > idx && candidates[i] == candidates[i - 1]) continue;

            // stop if number exceeds target
            if (candidates[i] > target) break;

            ans.add(candidates[i]);
            solve(i + 1, candidates, target - candidates[i], ans, output);
            ans.remove(ans.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> output = new ArrayList<>();
        solve(0, candidates, target, new ArrayList<>(), output);
        return output;
    }
}

