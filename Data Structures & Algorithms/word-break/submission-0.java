class Solution {
    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        boolean isTerminal = false;
    }

    public boolean trieSolution(String s, List<String> wordDict){
        TrieNode root = new TrieNode();

        for(String word: wordDict){
            TrieNode cur = root;
            for(char ch: word.toCharArray()){
                int idx = ch - 'a';
                if(cur.next[idx] == null){
                    cur.next[idx] = new TrieNode();
                }
                cur = cur.next[idx];
            }

            cur.isTerminal = true;
        }

        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for(int i = 0; i< len; i++){
            if(!dp[i]){
                continue;
            }

            TrieNode cur = root;
            for(int j = i; j < len; j++){
                int idx = s.charAt(j) - 'a';

                if(cur.next[idx] == null){
                    break;
                }

                cur = cur.next[idx];
                if(cur.isTerminal){
                    dp[j + 1] = true;
                }
            }
        }

        return dp[len];
    }

    public boolean dpSoln(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        Set<String> hst = new HashSet<>(wordDict);

        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }

        dp[0] = true;

        for(int i = 1; i <= len; i++){
            for(int j = i-1; j >= 0 && i - j <= maxLen; j--){
                if(dp[j] && hst.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[len];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return trieSolution(s, wordDict);
    }
}