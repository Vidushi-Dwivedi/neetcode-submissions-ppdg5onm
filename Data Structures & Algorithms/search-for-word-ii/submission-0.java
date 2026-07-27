class Solution {
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word = null; // Stores the complete word at the terminal node
        int instances = 0;  // Used for dynamic Trie pruning
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        // Step 2: DFS Backtracking from every cell
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode curr, List<String> result) {
        // Boundary conditions and visited check
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == '#') {
            return;
        }

        char ch = board[r][c];
        int idx = ch - 'a';

        // Prune branch if character path doesn't exist in Trie
        if (curr.next[idx] == null || curr.next[idx].instances == 0) {
            return;
        }

        TrieNode nextNode = curr.next[idx];
        
        // Word found!
        if (nextNode.word != null) {
            result.add(nextNode.word);
            // Critical Optimization: Erase word from Trie to avoid duplicate results 
            // and stop redundant future traversal paths
            eraseWord(rootPruneRef, nextNode.word); 
            nextNode.word = null; 
        }

        // Mark cell as visited
        board[r][c] = '#';

        // Explore 4 directions
        dfs(board, r + 1, c, nextNode, result);
        dfs(board, r - 1, c, nextNode, result);
        dfs(board, r, c + 1, nextNode, result);
        dfs(board, r, c - 1, nextNode, result);

        // Backtrack: Restore cell state
        board[r][c] = ch;
    }

    // Reference pointer to prune directly from root scope
    private TrieNode rootPruneRef;

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        rootPruneRef = root;
        for (String w : words) {
            TrieNode curr = root;
            for (char ch : w.toCharArray()) {
                int idx = ch - 'a';
                if (curr.next[idx] == null) {
                    curr.next[idx] = new TrieNode();
                }
                curr = curr.next[idx];
                curr.instances++;
            }
            curr.word = w;
        }
        return root;
    }

    // Optimized iterative / recursive Trie deletion to clear out paths
    private boolean eraseWord(TrieNode root, String word) {
        TrieNode curr = root;
        // Simple optimization: Just decrement instances down the path
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.next[idx] == null) return false;
            curr.next[idx].instances--;
            curr = curr.next[idx];
        }
        return true;
    }
}