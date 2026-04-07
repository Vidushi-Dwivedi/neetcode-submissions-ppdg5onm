class Solution {
    int[] parent;

    public int find(int node){
        if(parent[node] != node){
            parent[node] = find(parent[node]);
        }

        return parent[node];
    }

    public void union(int node1, int node2){
        int p_node1 = find(node1);
        int p_node2 = find(node2);

        if(p_node1 != p_node2){
            parent[p_node2] = p_node1;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        parent = new int[n + 1];

        for(int i = 0; i<= n; i++){
            parent[i] = i;
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            if(find(u) == find(v)){
                return edge;
            } else{
                union(u, v);
            }
        }

        return new int[0];
    }
}