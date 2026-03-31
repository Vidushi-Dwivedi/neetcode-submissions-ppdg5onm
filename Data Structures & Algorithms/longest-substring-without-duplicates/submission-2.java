class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int l =0, r = 0, len = 0;

        while(r >= l &&r<s.length()){
            char ch = s.charAt(r);

            if(map.containsKey(ch)){
               l = Math.max(l, map.get(ch) + 1);
            }

            len = Math.max(len, (r - l + 1));
            map.put(ch, r);
            r++;
        }

        return len;
    }
}
