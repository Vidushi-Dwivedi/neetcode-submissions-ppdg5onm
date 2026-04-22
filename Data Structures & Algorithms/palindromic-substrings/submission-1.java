class Solution {
     public int twoPointer(String s) {
        int len = s.length();
        int count = 0;

        for (int i = 0; i < len; i++) {
            // odd
            int l = i, r = i;
            while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }

            // even
            int le = i, re = i + 1;
            while (le >= 0 && re < len && s.charAt(le) == s.charAt(re)) {
                count++;
                le--;
                re++;
            }
        }

        return count;
    }
    public int countSubstrings(String s) {
        return twoPointer(s);
    }
}
