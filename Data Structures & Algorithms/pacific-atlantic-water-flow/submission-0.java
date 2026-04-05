class Solution {

    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public void dfs(int r, int c, boolean[][] visited, int[][] heights){
        visited[r][c] = true;

        for(int[] d : dirs){
            int nr = r + d[0];
            int nc = c + d[1];

            if(nr >= 0 && nr < heights.length &&
               nc >= 0 && nc < heights[0].length &&
               !visited[nr][nc] &&
               heights[nr][nc] >= heights[r][c]){

                dfs(nr, nc, visited, heights);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;

        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        // Pacific
        for(int i = 0; i < m; i++){
            dfs(i, 0, pac, heights);
            dfs(i, n-1, atl, heights);
        }

        for(int j = 0; j < n; j++){
            dfs(0, j, pac, heights);
            dfs(m-1, j, atl, heights);
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pac[i][j] && atl[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }
}