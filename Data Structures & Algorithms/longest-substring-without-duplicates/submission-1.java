class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int l =0, r = 0, len = 0;

        while(r >= l &&r<s.length()){
            char ch = s.charAt(r);

            while(map.containsKey(ch) && l < s.length()){
               map.remove(s.charAt(l++)); 
            }

            len = Math.max(len, (r - l + 1));
            map.put(ch, 1);
            r++;
        }

        return len;
    }
}
