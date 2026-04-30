class Solution {
    public int opt(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];

        for(int i = 0; i< m; i++){
            for(int j = 0; j< n; j++){
                if( i== 0 && j == 0){
                    dp[j] = grid[i][j];
                } else if(i == 0){
                    dp[j] = dp[j - 1] + grid[i][j];
                } else if(j == 0){
                    dp[j] = dp[j] + grid[i][j];
                } else{
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
                }
            }
        } 

        return dp[n-1];
    }

    public int tab(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        int sum = 0;
        for(int i = 0; i< m; i++){
            sum = sum + grid[i][0];
            dp[i][0] = sum;
        }

        sum = 0;
        for(int j = 0; j< n; j++){
            sum += grid[0][j];
            dp[0][j] = sum;
        }

        for(int i = 1; i< m; i++){
            for(int j = 1; j< n; j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }

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

        // int[][] dp = new int[grid.length][grid[0].length];

        // for(int i = 0; i< grid.length; i++){
        //     Arrays.fill(dp[i], -1);
        // }

        // return memo(grid, 0, 0, dp);

        // return tab(grid);
        return opt(grid);
    }
}