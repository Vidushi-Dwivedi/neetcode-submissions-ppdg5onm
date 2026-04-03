class Solution {
    public void addSoln(List<List<String>> ans, char[][] temp, int n){
        List<String> slist = new ArrayList<>();

        for(int i =0; i< n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                sb.append(temp[i][j]);
            }
            slist.add(sb.toString());
        }

        ans.add(new ArrayList(slist));
    }

    public boolean isValid(int n, int col, int row, char[][] temp){
        //check horizontal
        for(int j = 0; j<col; j++){
            if(temp[row][j] == 'Q'){
                return false;
            }
        }

        //check diagonal
        int i = row-1, j = col-1;

        while(i >= 0 && j >=0){
            if(temp[i][j] == 'Q'){
                return false;
            }
            i--;
            j--;
        }

        i = row + 1;
        j = col - 1;

        while(i < n && j >=0){
            if(temp[i][j] == 'Q'){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public void help(int n, int col, List<List<String>> ans, char[][] temp){
        if(col == n){
            addSoln(ans, temp, n); 
            return;
        }

        for(int row = 0; row< n; row++){
            if(isValid(n, col, row, temp)){
                temp[row][col] = 'Q';
                help(n, col + 1, ans, temp);
                temp[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] temp = new char[n][n];
        int[] visited = new int[n];

        int  i =0, j = 0;

        for(i = 0; i< n ; i++){
            for(j = 0; j< n; j++){
                temp[i][j] = '.';
            }
        }
        
        help(n, 0, ans, temp);

        return ans;
    }
}
