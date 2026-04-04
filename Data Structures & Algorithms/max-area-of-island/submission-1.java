class Solution {
    public int dfs(int row, int col, int[][] grid, boolean[][] visited){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
            return 0;
        }

        if(visited[row][col] || (grid[row][col] == 0)){ return 0;}

        visited[row][col] = true;

        return 1 + dfs(row + 1, col, grid, visited) + dfs(row, col + 1, grid, visited) +
                    dfs(row, col - 1, grid, visited) + dfs(row -1, col, grid, visited);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int max_area = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    int area = dfs(i, j, grid, visited);
                    System.out.println(area);
                    max_area = Math.max(max_area, area);
                }
            }
        }

        return max_area;
    }
}
