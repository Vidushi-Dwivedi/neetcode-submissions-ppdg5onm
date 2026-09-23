class Solution {
    private int findNextIndex(int[] startTime, int endTime){
        int start = 0, end = startTime.length - 1, nextIndex = startTime.length;

        while(start <= end){
            int mid = (start + end) / 2;
            if(startTime[mid] >= endTime){
                nextIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return nextIndex;
    }

    private int tab(List<List<Integer>> jobs, int[] startTime){
        int len = jobs.size();
        int[] dp = new int[len + 1];

        for(int i = len - 1; i >= 0; i--){
            int nextIdx = findNextIndex(startTime, jobs.get(i).get(1));
            int include = jobs.get(i).get(2) + dp[nextIdx];
            int exclude = dp[i + 1];

            dp[i] = Math.max(include, exclude);
        }

        return dp[0];
    }

    private int findMaxProfit(int i, int len, int[] dp, List<List<Integer>> jobs, int[] startTime){
        if(i == len){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        //Use
        int nextIdx = findNextIndex(startTime, jobs.get(i).get(1));
        int include = jobs.get(i).get(2) + findMaxProfit(nextIdx, len, dp, jobs, startTime);

        int exclude = findMaxProfit(i + 1, len, dp, jobs, startTime);

        dp[i] = Math.max(include, exclude);

        return dp[i];
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<List<Integer>> jobs = new ArrayList<>();
        int len = startTime.length;

        for(int i = 0; i< len; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(startTime[i]);
            temp.add(endTime[i]);
            temp.add(profit[i]);
            jobs.add(temp);
        }

        jobs.sort(Comparator.comparingInt(a -> a.get(0)));

        int[] dp = new int[len + 1];
        Arrays.fill(dp, -1);

        //Start time sorted
        for(int i = 0; i< len; i++){
            startTime[i] = jobs.get(i).get(0);
        }

        // return findMaxProfit(0, len, dp, jobs, startTime);
        return tab(jobs, startTime);
    }
}