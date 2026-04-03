class Solution {
    public void addSoln(List<List<String>> ans, char[][] temp, int n){
        List<String> slist = new ArrayList<>();

        for(int i =0; i< n; i++){
            String str = "";
            for(int j =0; j< n; j++){
                str = str + temp[i][j];
            }
            slist.add(str);
        }

        ans.add(new ArrayList(slist));
    }

    public boolean isValid(int n, int col, int row, char[][] temp, int[] visited){
        if(visited[row] == 1){ return false;}

        //check horizontal
        for(int j = 0; j<=col; j++){
            if(temp[row][j] != '.'){
                return false;
            }
        }

        //check diagonal
        int i = row, j = col;

        while(i >= 0 && j >=0){
            if(temp[i][j] == 'Q'){
                return false;
            }
            i--;
            j--;
        }

        i = row;
        j = col;

        while(i < n && j >=0){
            if(temp[i][j] == 'Q'){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public void help(int n, int col, List<List<String>> ans, char[][] temp, int[] visited){
        if(col == n){
            addSoln(ans, temp, n); 
            return;
        }

        for(int row = 0; row< n; row++){
            if(isValid(n, col, row, temp, visited)){
                temp[row][col] = 'Q';
                visited[row] = 1;
                help(n, col + 1, ans, temp, visited);
                temp[row][col] = '.';
                visited[row] = 0;
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
        
        help(n, 0, ans, temp, visited);

        return ans;
    }
}
