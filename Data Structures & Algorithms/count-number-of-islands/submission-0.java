class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int island = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    island++;
                }
            }
        }
        return island;
    }

    private void dfs(int i, int j, char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '0'; 

        dfs(i - 1, j, grid);
        dfs(i + 1, j, grid);
        dfs(i, j - 1, grid);
        dfs(i, j + 1, grid);
    }
}
