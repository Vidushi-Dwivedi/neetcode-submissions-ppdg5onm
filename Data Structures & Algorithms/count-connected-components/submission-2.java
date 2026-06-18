class Solution {
    class DSU{
        int[] parent, rank;
        int components;

        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            components = n;

            for(int i = 0; i< n; i++){
                parent[i] = i;
            }
        }

        public int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        public void union(int a, int b){
            int pa = find(a);
            int pb = find(b);

            if(pa == pb){ return;}

            if(rank[pa] > rank[pb]){ parent[pb] = pa; }
            else if( rank[pb] > rank[pa]){ parent[pa] = pb;}
            else{
                parent[pa] = pb;
                rank[pb]++;
            }

            components--;
        }
    }
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);

        for(int[] e: edges){
            dsu.union(e[0], e[1]);
        }

        return dsu.components;
    }
}
