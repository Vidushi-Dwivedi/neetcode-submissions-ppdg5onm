class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        boolean[] visited = new boolean[n];

        for(int i = 0; i<n; i++){
            adj.put(i, new ArrayList<Integer>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int count = 0;

        for(int i = 0; i<n; i++){
            if(!visited[i]){
                count++;
                System.out.println(i + "   " + count);
                dfs(i, -1, visited, adj);
            }
        }

        return count;
    }

    public void dfs(int node, int parent, boolean[] visited, Map<Integer, List<Integer>> adj){
        visited[node] = true;

        for(int neighbor: adj.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor, node, visited, adj);
            }
        }
    }
}
