class Solution {
    public boolean isSameFreq(int[] map, int[] freq_map){
        for(int i = 0; i<26; i++){
            if(map[i] != freq_map[i]){ return false; }
        }

        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[26];

        for(char ch: s1.toCharArray()){
            map[ch - 'a']++;
        }

        int window = s1.length();

        for(int i = 0; i <= (s2.length() - s1.length()); i++){
            int[] freq_map = new int[26];

            for(int j = i; j < (i + window); j++){
                freq_map[s2.charAt(j) - 'a']++;
            }

            if(isSameFreq(map, freq_map)){ return true;}
        } 

        return false;
    }
}
