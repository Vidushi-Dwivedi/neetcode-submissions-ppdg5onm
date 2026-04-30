class Solution {
    // public int tab

    public int memo(int[][] grid, int i, int j, int[][] dp){
        if(i >= grid.length || j >= grid[0].length){
            return Integer.MAX_VALUE;
        }

        if(i == grid.length - 1 && j == grid[0].length -1){
            return grid[i][j];
        }

        if(dp[i][j] == -1){
            int down = memo(grid, i + 1, j, dp);
            int right = memo(grid, i, j + 1, dp);

            dp[i][j] = grid[i][j] + Math.min(down, right);
        }

        return dp[i][j];
    } 

    public int helper(int[][] grid, int i, int j){
        if(i >= grid.length || j >= grid[0].length){
            return Integer.MAX_VALUE;
        }

        if(i == grid.length - 1 && j == grid[0].length -1){
            return grid[i][j];
        }

        int down = helper(grid, i + 1, j);
        int right = helper(grid, i, j + 1);

        return grid[i][j] + Math.min(down, right);
    }

    public int minPathSum(int[][] grid) {
        // return helper(grid, 0, 0);

        int[][] dp = new int[grid.length][grid[0].length];

        for(int i = 0; i< grid.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return memo(grid, 0, 0, dp);
    }
}