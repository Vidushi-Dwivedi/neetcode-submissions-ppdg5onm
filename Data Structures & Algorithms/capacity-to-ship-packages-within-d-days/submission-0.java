class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0, min = 0;

        for(int n: weights){
            max += n;
            min = Math.max(min, n); 
        }

        int cap = min;

        while(min <= max){
            int mid = min + (max - min) / 2;
            
            if(canLoad(weights, mid, days)){
                cap = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return cap;
    }

    private boolean canLoad(int[] weights, int capacity, int days) {
        int daysUsed = 1;
        int currentLoad = 0;

        for (int w : weights) {
            if (currentLoad + w > capacity) {
                daysUsed++;
                currentLoad = 0;
            }
            currentLoad += w;
        }

        return daysUsed <= days;
    }
}