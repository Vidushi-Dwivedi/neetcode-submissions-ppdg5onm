class Solution {
    public int memo(int[][] matrix, int i, int j, int[][] dp){
        int up = 0, down = 0, left = 0, right = 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(i + 1 < matrix.length && matrix[i][j] < matrix[i+1][j]){
            down = memo(matrix, i + 1, j, dp);
        }
        if(i - 1 >= 0 && matrix[i][j] < matrix[i - 1][j]){
            up = memo(matrix, i - 1, j, dp);
        }
        if(j + 1 < matrix[0].length && matrix[i][j] < matrix[i][j + 1]){
            right = memo(matrix, i, j + 1, dp);
        }
        if(j - 1 >= 0 && matrix[i][j] < matrix[i][j - 1]){
            left = memo(matrix, i, j - 1, dp);
        }

        return dp[i][j] = 1 + Math.max(Math.max(up, down), Math.max(left, right));
    }

    public int helper(int[][] matrix, int i, int j){
        // if(i< 0 || i >= matrix.length || j < 0 || j >= matrix[0].length){
        //     return 0;
        // }

        int up = 0, down = 0, left = 0, right = 0;
        if(i + 1 < matrix.length && matrix[i][j] < matrix[i+1][j]){
            down = helper(matrix, i + 1, j);
        }
        if(i - 1 >= 0 && matrix[i][j] < matrix[i - 1][j]){
            up = helper(matrix, i - 1, j);
        }
        if(j + 1 < matrix[0].length && matrix[i][j] < matrix[i][j + 1]){
            right = helper(matrix, i, j + 1);
        }
        if(j - 1 >= 0 && matrix[i][j] < matrix[i][j - 1]){
            left = helper(matrix, i, j - 1);
        }

        return 1 + Math.max(Math.max(up, down), Math.max(left, right));
    }

    public int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for(int i = 0; i< n ; i++){
            Arrays.fill(dp[i], -1);
        }

        for(int i = 0; i< n; i++){
            for(int j = 0; j<m; j++){
                // ans = Math.max(ans, helper(matrix, i, j));

                ans = Math.max(ans, memo(matrix, i, j, dp));
            }
        }
        
        return ans;
    }
}
