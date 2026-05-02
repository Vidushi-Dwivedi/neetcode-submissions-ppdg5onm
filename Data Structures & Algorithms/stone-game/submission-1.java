class Solution {
    public int memo(int[] piles, int i, int j, int[][] dp){
       if(i == j){
            return piles[i];
        }
        if(i > j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        } 

        int choice1 = piles[i] + Math.min(memo(piles, i+2, j, dp), memo(piles, i + 1, j-1, dp));
        int choice2 = piles[j] + Math.min(memo(piles, i + 1, j - 1, dp), memo(piles, i, j - 2, dp));

        return dp[i][j] = Math.max(choice1, choice2);
    }

    public int helper(int[] piles, int i, int j){
        if(i == j){
            return piles[i];
        }
        if(i > j){
            return 0;
        }

        int choice1 = piles[i] + Math.min(helper(piles, i+2, j), helper(piles, i + 1, j-1));
        int choice2 = piles[j] + Math.min(helper(piles, i + 1, j - 1), helper(piles, i, j - 2));

        return Math.max(choice1, choice2);
    }
    public boolean stoneGame(int[] piles) {
        int total = 0;
        for(int x: piles){
            total += x;
        }

        // int alice = helper(piles, 0, piles.length - 1);

        int[][] dp = new int[piles.length][piles.length];
        for(int i = 0; i< piles.length; i++){
            Arrays.fill(dp[i], -1);
        }

        int alice = memo(piles, 0, piles.length - 1, dp);

        if(alice > total/2){
            return true;
        } else{
            return false;
        }
    }
}