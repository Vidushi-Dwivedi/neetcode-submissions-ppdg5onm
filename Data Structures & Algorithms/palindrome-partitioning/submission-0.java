class Solution {
    public boolean isPalindrome(String s){
        int l = s.length() - 1;
        int i = 0;

        // System.out.println(s);

        while(i < l){
            if(s.charAt(i) != s.charAt(l)){
                return false;
            }

            i++;
            l--;
        }

        return true;
    }
    public void getPartitions(String s, int i, List<List<String>> ans , List<String> lst){
        if( i >= s.length()){
            if(!lst.isEmpty()){
                ans.add(new ArrayList(lst));
            }

            return;
        }

        for(int k =  i; k < s.length(); k++){
            if(isPalindrome(s.substring(0, k + 1))){
                lst.add(s.substring(0, k + 1));
                getPartitions(s.substring(k + 1), 0, ans, lst);
                lst.remove(lst.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> lst = new ArrayList<>();

        getPartitions(s, 0, ans, lst);

        return ans;
    }
}
