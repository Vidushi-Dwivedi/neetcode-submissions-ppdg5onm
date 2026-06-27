class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        char ch[] = s.toCharArray();

        while(i < j){
            if(ch[i] == ch[j]){
                i++;
                j--;
                continue;
            }

            return isPurePalindrome(ch, i + 1, j) || isPurePalindrome(ch, i, j - 1);
        }

        return true;
    }

    public boolean isPurePalindrome(char[] ch, int i, int j){
        while(i < j){
            if(ch[i] != ch[j]){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}