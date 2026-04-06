class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        boolean[] visited = new boolean[n];

        // Build graph
        for(int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }


        boolean ans = isCyclicDFS(0, -1, visited, adj);

        if(ans){ return false; }

        for(int i = 0; i< n; i++){
            if(!visited[i]){
                return false;
            }
        }

        return true;
    }

    public boolean isCyclicDFS(int node, int parent, boolean[] visited, Map<Integer, List<Integer>> adj){
        visited[node] = true;

        for(int neighbor: adj.get(node)){
            if(!visited[neighbor] ){
                if(isCyclicDFS(neighbor, node, visited, adj)){
                    return true;
                }
            }
            else if( neighbor != parent){
                return true;
            }
        }

        return false;

    }
}
