class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        int[] map1 = new int[26];
        int[] map2 = new int[26];

        for(int i = 0; i< s1.length(); i++){
            int k = s1.charAt(i) - 'a';
            map1[k]++;
        }

        int r = 0, l = 0;
        while(r < s2.length()){
            // System.out.println("l = " + l + " r = " + r);
            //Add to the window
            map2[s2.charAt(r) - 'a']++;

            if(r - l + 1 > s1.length()){
                map2[s2.charAt(l++) - 'a']--;
            }

            if(r- l + 1 == s1.length()){
                // System.out.println("In equal check: l = " + l + " r = " + r);
                if(checkIfEqual(map1, map2)) return true;
            }

            r++;
        }

        return false;
    }

    public boolean checkIfEqual(int[] map1, int[] map2){
        for(int i = 0; i< 26; i++){
            if(map1[i] != map2[i]){
                System.out.println("Here");
                return false;
            }
        }

        return true;
    }
}
