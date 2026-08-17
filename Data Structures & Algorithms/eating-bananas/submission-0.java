class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        for(int p : piles){
            max = Math.max(max, p);
        }

        int low = 1;
        int high = max;
        int k = max;

        while(low <= high){
            int mid = low + (high - low)/ 2;

            if(canEat(mid, piles, h)){
                k = mid;
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }

        return k;
    }

    public boolean canEat(int k, int[] piles, int h){
        long hour = 0;

        for(int p: piles){
            hour += (p + k - 1) / k;
            
            if(hour > h) {
                return false;
            }
        }

        return true;
    }
}