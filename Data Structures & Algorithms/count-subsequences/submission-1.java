class Solution {
    public int memo(String s, String t, String x, int i, Map<String, Integer> map){
        if(x.length() == t.length()){
            if(x.equals(t)){
                return 1;
            } else{
                return 0;
            }
        }
        if(i >= s.length()){
            return 0;
        }

        String key = x + "," + String.valueOf(i);

        if(map.containsKey(key)){
            return map.get(key);
        }

        int include = memo(s, t, x + s.charAt(i), i + 1, map);
        int exclude = memo(s, t, x, i + 1, map);

        map.put(key, include + exclude);
        return include + exclude;
    }

    public int helper(String s, String t, String x, int i){
        if(x.length() == t.length()){
            if(x.equals(t)){
                return 1;
            } else{
                return 0;
            }
        }
        if(i >= s.length()){
            return 0;
        }

        int include = helper(s, t, x + s.charAt(i), i + 1);
        int exclude = helper(s, t, x, i + 1);

        return include + exclude;
    }
    public int numDistinct(String s, String t) {
        // return helper(s, t, "", 0);

        Map<String, Integer> map = new HashMap<>();

        return memo(s, t, "", 0, map);
    }
}
