class Solution {
    public String foreignDictionary(String[] words) {
        // Step 1a: Initialize structures for all unique letters
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegree.put(c, 0);
                graph.put(c, new HashSet<>());
            }
        }

        // Step 1b: Compare adjacent words to build directed edges
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            // Edge Case Trap: Check if word2 is a prefix of word1 (e.g., "abc" before "ab")
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return ""; // Invalid dictionary order
            }

            int minLength = Math.min(word1.length(), word2.length());
            for (int j = 0; j < minLength; j++) {
                char parent = word1.charAt(j);
                char child = word2.charAt(j);

                // Find the first character difference
                if (parent != child) {
                    // If this relationship hasn't been recorded yet
                    if (!graph.get(parent).contains(child)) {
                        graph.get(parent).add(child); // Add arrow: parent -> child
                        inDegree.put(child, inDegree.get(child) + 1); // Increment incoming count
                    }
                    break; // Stop comparing the rest of these two words
                }
            }
        }

        // Implement topo
        Queue<Character> q = new LinkedList<Character>();
        String s = "";

        for (Map.Entry<Character, Integer> es : inDegree.entrySet()) {
            if (es.getValue() == 0) {
                q.add(es.getKey());
            }
        }

        while (!q.isEmpty()) {
            char ch = q.poll();
            s = s + ch;

            for (char nei : graph.get(ch)) {
                int deg = inDegree.get(nei);
                inDegree.put(nei, --deg);

                if (deg == 0) {
                    q.offer(nei);
                }
            }
        }

        // FIXED: Cycle Detection Check
        // If our built path is shorter than total unique characters, a loop exists
        if (s.length() < inDegree.size()) {
            return "";
        }

        return s;
    }
}
