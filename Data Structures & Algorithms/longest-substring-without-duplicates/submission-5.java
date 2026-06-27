class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int max_len = 0;
        int l = 0;

        for(int i = 0; i< arr.length; i++){
            if(map.containsKey(arr[i])){
                l = Math.max(l, map.get(arr[i]) + 1);
            }

            max_len = Math.max(max_len, i - l + 1);
            map.put(arr[i], i);
        }

        return max_len;
    }
}
