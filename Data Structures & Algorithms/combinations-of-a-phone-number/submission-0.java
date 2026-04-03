class Solution {
    public void helper(String[] codes, String digits, List<String> ans, String str, int i){
        if(i >= digits.length()){
            ans.add(str);
            return;
        }

        String s = codes[(digits.charAt(i) - '0') - 2];

        for(int j = 0; j< s.length(); j++){
            helper(codes, digits, ans, str + s.charAt(j), i+1);
        }
    }

    public List<String> letterCombinations(String digits) {
        String[] codes = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<String>();

        if(digits.length() == 0){
            return ans;
        }

        helper(codes, digits, ans, "", 0);

        return ans;
    }
}
