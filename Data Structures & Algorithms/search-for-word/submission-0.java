class Solution {
    public boolean help(char[][] board, String word, int x, int y, int i){
        if(x < 0 || y < 0 || x >= board.length || y>=board[0].length){
            return false;
        }

        if(board[x][y] != word.charAt(i)){
            return false;
        }

        if(i == word.length() - 1){
            return true;
        }

        char ch = board[x][y];
        board[x][y] = '#';

        boolean ans = help(board, word, x + 1, y, i + 1) ||
                        help(board, word, x, y + 1, i + 1) ||
                        help(board, word, x - 1, y, i + 1) ||
                        help(board, word, x, y - 1, i + 1);

        board[x][y] = ch;
        return ans;
    }

    public boolean exist(char[][] board, String word) {
         boolean soln = false;

        for(int i = 0; i< board.length; i++){
            for(int j = 0; j< board[0].length; j++){
                if(help(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        

        return soln;
    }
}
