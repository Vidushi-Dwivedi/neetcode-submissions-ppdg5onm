class Solution {
    public boolean checkBlock(char[][] board, int i_ind, int j_ind){
        int[] check = new int[10];
        for(int i = i_ind; i< i_ind + 3; i++){
            for(int j = j_ind; j < j_ind + 3; j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] -'0';
                    if(check[num] == 0){
                        check[num] = 1;
                    } else{ return false;}
                }
            }
        }

        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        //Check for each row
        for(int i = 0; i< row; i++){
            int[] row_check = new int[10];
            int[] col_check = new int[10];
            for(int j = 0; j< col; j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] -'0';
                    if(row_check[num] == 0){
                        row_check[num] = 1;
                    } else{ return false;}
                }
                if(board[j][i] != '.'){
                    int num = board[j][i] -'0';
                    if(col_check[num] == 0){
                        col_check[num] = 1;
                    } else{ return false;}
                }
            }
        }

        //Check for each col
        // for(int i = 0; i< row; i++){
        //     int[] check = new int[10];
        //     for(int j = 0; j< col; j++){
        //         if(board[j][i] != '.'){
        //             int num = board[j][i] -'0';
        //             if(check[num] == 0){
        //                 check[num] = 1;
        //             } else{ return false;}
        //         }
        //     }
        // }

        //Check for 3 * 3 block
        for(int i = 0; i< row; i = i+ 3){
            for(int j = 0; j< col; j = j + 3){
                if(!checkBlock(board, i, j)){
                    return false;
                }
            }
        }

        return true;
    }
}