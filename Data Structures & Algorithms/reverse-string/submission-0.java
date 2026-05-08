class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int l = s.length - 1;

        while(i < l){
            char temp = s[i];
            s[i++] = s[l];
            s[l--] = temp;
        }
    }
}