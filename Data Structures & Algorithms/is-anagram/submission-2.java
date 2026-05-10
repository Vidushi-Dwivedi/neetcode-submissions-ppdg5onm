class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];

        if(s.length() != t.length()){
            return false;
        }

        for(int i =0; i< s.length(); i++){
            int pos = (int)s.charAt(i);
            arr[pos-97]++;
        }

        for(int i =0; i< t.length(); i++){
            int pos = (int)t.charAt(i);
            
            if(arr[pos-97] ==0){
                return false;
            }
            else{
                arr[pos-97]--;
            }
        }

        return true;
    }
}
