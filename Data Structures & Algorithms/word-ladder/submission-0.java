class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        
        wordList.add(beginWord);

        Map<String, List<String>> adj = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                char[] chars = word.toCharArray();
                chars[i] = '*';
                String pattern = new String(chars);
                adj.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        Deque<String> queue = new ArrayDeque<>();
        queue.addLast(beginWord);

        int res = 1;

        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String word = queue.pollFirst();
                if (word.equals(endWord)) return res;
                for (int j = 0; j < word.length(); j++) {
                    char[] chars = word.toCharArray();
                    chars[j] = '*';
                    String pattern = new String(chars);
                    for (String adjWord : adj.getOrDefault(pattern, List.of())) {
                        if (!visited.contains(adjWord)) {
                            visited.add(adjWord);
                            queue.addLast(adjWord);
                        }
                    }
                }
            }
            res++;
        }

        return 0;
    }
}