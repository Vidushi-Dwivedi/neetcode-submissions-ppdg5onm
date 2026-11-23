class NumMatrix {
    int[][] pre_matrix;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        pre_matrix = new int[n + 1][m + 1];

        for(int i = 0; i< n; i++){
            int x = i + 1;
            for(int j = 0; j < m; j++) {
                int y = j + 1;
                pre_matrix[x][y] = pre_matrix[x][y - 1] + pre_matrix[x - 1][y] 
                            + matrix[i][j] - pre_matrix[x - 1][y - 1]; 
            }
        }   
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result  = pre_matrix[row2 + 1][col2 + 1] - pre_matrix[row2 + 1][col1]
                        - pre_matrix[row1][col2 + 1] + pre_matrix[row1][col1];
        
        return result;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */