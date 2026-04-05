class Solution {
    class Pair{
        int row; int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    Queue<Pair> que = new LinkedList<Pair>();

    public int orangesRotting(int[][] grid) {
        int min =0;

        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                if(grid[i][j] == 2){
                    que.offer(new Pair(i, j));
                }
            }
        }

        Pair[] dirs = {
                        new Pair(-1, 0), 
                        new Pair(1, 0), 
                        new Pair(0, -1), 
                        new Pair(0, 1)
                    };

        while(!que.isEmpty()){
            boolean rotted = false;
            int len = que.size();

            while(len > 0){
                Pair cur = que.poll();

                for(Pair pp: dirs){
                    int rn = cur.row + pp.row;
                    int cn = cur.col + pp.col;

                    if(rn < 0 || rn >= grid.length || cn < 0 || cn >=grid[0].length || grid[rn][cn]==0){
                        continue;
                    }

                    if(grid[rn][cn] == 1){
                        grid[rn][cn] = 2;
                        que.offer(new Pair(rn, cn));
                        rotted = true;
                    }
                }

                len--;
            }
            if(rotted){ min++; }
        }

        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return min;
    }
}