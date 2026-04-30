class Solution {
    public int tab(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        if(grid[m-1][n-1] == 1) return 0;
        dp[m-1][n-1] = 1;

        for(int i = m-1; i>= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(i == m - 1 && j == n-1){
                    continue;
                }

                if(grid[i][j] == 1){
                    dp[i][j] = 0;
                } else{
                    dp[i][j] += (i + 1 < m)? dp[i + 1][j] : 0;
                    dp[i][j] += (j + 1 < n)? dp[i][j + 1] : 0;
                }
            }
        }

        return dp[0][0];
    }

    public int memo(int[][] obstacleGrid, int[][] dp, int i, int j){
        if(i >= dp.length || j >= dp[0].length || obstacleGrid[i][j] == 1){
            return 0;
        }

        if(i == obstacleGrid.length - 1 && j == obstacleGrid[0].length -1){
            return 1;
        }

        if(dp[i][j] == -1){
            dp[i][j] = memo(obstacleGrid, dp, i + 1, j) + memo(obstacleGrid, dp, i, j + 1);
        }

        return dp[i][j];
    }

    public int helper(int[][] obstacleGrid, int m, int n, int i, int j){
        if(i >= m || j >= n || obstacleGrid[i][j] == 1){
            return 0;
        }
        if(i == m - 1 && j == n - 1){
            return 1;
        }

        return helper(obstacleGrid, m, n, i + 1, j) + helper(obstacleGrid, m, n, i, j + 1);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // int m = obstacleGrid.length;
        // int n = obstacleGrid[0].length;

        // int[][] dp = new int[m][n];

        // for(int i = 0; i< m; i++){
        //     Arrays.fill(dp[i], -1);
        // }

        // return memo(obstacleGrid, dp, 0, 0);

        // return helper(obstacleGrid, m, n, 0, 0);

        return tab(obstacleGrid);
    }
}