class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) {return 0;}

        Set<String> visited = new HashSet<>();
        Set<String> beginSet = new HashSet<String>(Set.of(beginWord));
        Set<String> endSet = new HashSet<String>(Set.of(endWord));
        int level = 1;

        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            if(beginSet.size() > endSet.size()){
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextLevel = new HashSet<>();
            for(String word: beginSet){
                char[] s = word.toCharArray();
                for(int i = 0; i< s.length; i++){
                    char original = s[i];
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        s[i] = ch;
                        String newStr = new String(s);

                        if(endSet.contains(newStr)){
                            return level + 1;
                        }

                        if(dict.contains(newStr) && !visited.contains(newStr)){
                            nextLevel.add(newStr);
                            visited.add(newStr);
                        }
                    }

                    s[i] = original;
                }
            }

            beginSet = nextLevel;
            level++;
        }

        return 0;
    }
}