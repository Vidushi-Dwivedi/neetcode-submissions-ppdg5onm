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

        public boolean union(int a, int b){
            int pa = find(a);
            int pb = find(b);

            if(pa == pb){ return false;}

            if(rank[pa] > rank[pb]){ parent[pb] = pa; }
            else if( rank[pb] > rank[pa]){ parent[pa] = pb;}
            else{
                parent[pa] = pb;
                rank[pb]++;
            }

            components--;
            return true;
        }
    }
    
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int nodes = edges.length;
        int[] ans = new int[2];

        DSU dsu = new DSU(nodes + 1);

        for(int[] e: edges){
            if(!dsu.union(e[0], e[1])){
                ans = e;
            }
        }

        return ans;
    }
}