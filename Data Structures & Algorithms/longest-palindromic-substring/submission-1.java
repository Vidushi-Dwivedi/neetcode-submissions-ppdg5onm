class Solution {
    //Two pointer
    public String twoPointer(String s){
        int len = s.length();
        int sLen1 = 0, sLen2 = 0;
        String str1 = "", str2 = "";

        for(int i = 0; i< len; i++){
            //odd
            int l = i, r= i;
            while(l >= 0 && r < len && s.charAt(l) == s.charAt(r)){
                if((r - l) + 1 > sLen1){
                    sLen1 = (r - l) + 1;
                    str1 = s.substring(l, r + 1);
                }
                l--;
                r++;
            }

            //even
            int le = i, re = i + 1;
            while(le >= 0 && re < len && s.charAt(le) == s.charAt(re)){
                if(re-le + 1> sLen2){
                    sLen2 = (re - le) + 1;
                    str2 = s.substring(le, re + 1);
                }
                
                le--;
                re++;
            }
        }

        return (sLen1 > sLen2)? str1 : str2;
    }
    public String longestPalindrome(String s) {
        return twoPointer(s);
    }
}
