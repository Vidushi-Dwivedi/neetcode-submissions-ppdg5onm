class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) return 1;
        
        int[] score = new int[n + 1];
        
        for (int[] t : trust) {
            score[t[0]]--;  // person t[0] trusts someone, loses a point
            score[t[1]]++;  // person t[1] is trusted, gains a point
        }
        
        for (int i = 1; i <= n; i++) {
            if (score[i] == n - 1) return i;
        }
        
        return -1;
    }
}