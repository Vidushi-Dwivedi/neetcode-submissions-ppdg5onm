class Solution {
    public int totalFruit(int[] fruits) {
        int r = 0, l = 0, max_len = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        while(r < fruits.length){
            map.putIfAbsent(fruits[r], 0);
            map.put(fruits[r], map.get(fruits[r]) + 1); 
            
            if(map.size() > 2){
                int num = fruits[l];
                map.put(num, map.get(num) - 1);
                
                if(map.get(num) == 0){
                    map.remove(num);
                }

                l++;
            }

            if(map.size() <= 2){
                max_len = Math.max(max_len, r - l + 1);
            }

            r++;
        }

        return max_len;
    }
}