class Solution {
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        boolean isTerminal = false;
    }

    //Creating memo map
    Map<Integer, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();

        //Creating trie structure from wordDict
        for (String str : wordDict) {
            TrieNode cur = root;

            for (char ch : str.toCharArray()) {
                int idx = ch - 'a';

                if (cur.next[idx] == null) {
                    cur.next[idx] = new TrieNode();
                }

                cur = cur.next[idx];
            }
            cur.isTerminal = true;
        }

        return dfs(s, 0, root);
    }

    public List<String> dfs(String s, int start, TrieNode root) {
        if (map.containsKey(start)) {
            return map.get(start);
        }

        List<String> res = new ArrayList<>();
        int len = s.length();

        if (start == len) {
            res.add("");
            return res;
        }

        TrieNode cur = root;
        for (int j = start; j < len; j++) {

            int idx = s.charAt(j) - 'a';

            if (cur.next[idx] == null) {
                break;
            }

            cur = cur.next[idx];

            if (cur.isTerminal) {
                String word = s.substring(start, j + 1);
                List<String> subRes = dfs(s, j + 1, root);

                for (String str : subRes) {
                    if (str.isEmpty()) {
                        res.add(word);
                    } else {
                        res.add(word + " " + str);
                    }
                }
            }
        }

        map.put(start, res);
        return res;
    }
}