class Solution {
    public int find(int x, int[] parent){
        if(parent[x] != x){
            parent[x] = find(parent[x], parent);
        }

        return parent[x];
    }

    public void union(int u, int v, int[] parent, int[] rank){
        int pu = find(u, parent);
        int pv = find(v, parent);
        if(pu != pv){
            if(rank[pu] > rank[pv]){
                parent[pv] = pu;
            } else if(rank[pv] > rank[pu]){
                parent[pu] = pv;
            } else{
                parent[pu] = pv;
                rank[pv]++;
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int[] rank = new int[isConnected.length];
        int[] parent = new int[isConnected.length];
        List<List<Integer>> edges = new ArrayList<>();

        for(int i = 0; i< isConnected.length; i++){
            parent[i] = i;
        }

        for(int i = 0; i < isConnected.length; i++){
            for(int j = i + 1; j < isConnected.length; j++){
                if(isConnected[i][j] == 1){
                    union(i, j, parent, rank);
                }
            }
        }


        for(List<Integer> edge: edges){
            union(edge.get(0), edge.get(1), parent, rank);
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i< parent.length; i++){
            int x = find(parent[i], parent);

            set.add(x);
        }

        return set.size();
    }
}