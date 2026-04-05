class Solution {
    int[][] dirs = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};

    public void dfs(char[][] board, int i, int j){
        board[i][j] = 'M';

        for(int[] coord : dirs){
            int in = i + coord[0];
            int jn = j + coord[1];

            if(in>=0 && in<board.length && jn>=0 && jn<board[0].length
            && board[in][jn] == 'O'){
                dfs(board, in, jn);
            }
        }
    }
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        //top row
        for(int i = 0; i< col; i++){
            if(board[0][i] == 'O'){
                dfs(board, 0, i);
            }
        }

        //left side - top left corner
        for(int i =1; i< row; i++){
            if(board[i][0] == 'O'){
                dfs(board, i, 0);
            }
        }

        //bottom row -bottom left corner
        for(int i = 1; i< col; i++){
            if(board[row-1][i] == 'O'){
                dfs(board, row-1, i);
            }
        }

        //right col - upper and lower corner
        for(int i = 1; i< row-1; i++){
            if(board[i][col-1] == 'O'){
                dfs(board, i, col-1);
            }
        }

        for(int i = 0; i< row; i++){
            for(int j = 0; j< col; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }

                if(board[i][j] == 'M'){
                    board[i][j] = 'O';
                }
            }
        }
    }
}