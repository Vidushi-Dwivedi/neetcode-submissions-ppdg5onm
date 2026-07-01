class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i< t.length(); i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        } 

        int need = map.size();
        int have = 0;
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int minLeft = 0;
        int minRight = 0;

        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if(map.containsKey(ch) && map.get(ch).equals(window.get(ch))){
                have++;
            }

            while(have == need){
                //Update min len
                if(right - left + 1 < minLen){
                    minLen = right- left + 1;
                    minLeft = left;
                    minRight = right;
                }

                char dh = s.charAt(left);
                window.put(dh, window.get(dh) - 1);

                if(map.containsKey(dh) && window.get(dh) < map.get(dh)){
                    have--;
                }

                left++;
            }
        }

        return (minLen < Integer.MAX_VALUE)? s.substring(minLeft, minRight + 1) : "";
    }
}
