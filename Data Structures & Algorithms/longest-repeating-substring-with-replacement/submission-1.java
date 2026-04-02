class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, max_freq = 0, max_len = 0;
        int[] map = new int[26];

        while(r < s.length()){
            char ch = s.charAt(r);
            map[ch - 'A']++;

            max_freq = Math.max(max_freq, map[ch - 'A']);

            if((r - l + 1 - max_freq) > k){
                map[s.charAt(l) - 'A']--;
                l++;
            }

            if((r - l + 1 - max_freq) <= k){
                max_len = Math.max(max_len, (r - l +1));
            }

            r++;
        }  

        return max_len;
    }
}
