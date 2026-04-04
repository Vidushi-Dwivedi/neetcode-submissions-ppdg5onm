class Solution {
    public int dfs(int row, int col, int[][] grid){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
            return 0;
        }

        if(grid[row][col] == 0){ return 0;}

        grid[row][col] = 0;

        return 1 + dfs(row + 1, col, grid) + dfs(row, col + 1, grid) +
                    dfs(row, col - 1, grid) + dfs(row -1, col, grid);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int max_area = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    int area = dfs(i, j, grid);
                    max_area = Math.max(max_area, area);
                }
            }
        }

        return max_area;
    }
}
