class Solution {
    public int helper(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }

        if (grid[i][j] == 0 || grid[i][j] == 2) {
            return 0;
        }

        int perimeter = 0;

        if (i + 1 == grid.length || grid[i + 1][j] == 0) {
            perimeter++;
        }
        if (i - 1 == -1 || grid[i - 1][j] == 0) {
            perimeter++;
        }
        if (j + 1 == grid[0].length || grid[i][j + 1] == 0) {
            perimeter++;
        }
        if (j - 1 == -1 || grid[i][j - 1] == 0) {
            perimeter++;
        }

        grid[i][j] = 2;
        // System.out.println("i = " + i + "j = "+ j + "perimeter = " +perimeter);

        return perimeter + helper(grid, i + 1, j) + helper(grid, i, j + 1) + helper(grid, i - 1, j)
            + helper(grid, i, j - 1);
    }
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return helper(grid, i, j);
                }
            }
        }
        return 0;
    }
}