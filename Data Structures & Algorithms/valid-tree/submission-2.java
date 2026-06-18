class Solution {
    class DSU {
        int[] parent, rank;
        int components;

        DSU(int n){
            components = n;
            parent = new int[n];
            rank = new int[n];
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

        public boolean union(int a, int b){
            int pa = find(a);
            int pb = find(b);

            if(pa == pb){ return false;}
            else if(rank[pa] > rank[pb]) {
                parent[pb] = pa;
            } else if(rank[pb] > rank[pa]){
                parent[pa] = pb;
            } else{
                parent[pa] = pb;
                rank[pa]++;
            }

            components--;
            return true;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        DSU dsu = new DSU(n);

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            if(!dsu.union(u, v)){
                return false;
            }
        }

        if(dsu.components != 1){
            return false;
        }

        return true;
    }
}
