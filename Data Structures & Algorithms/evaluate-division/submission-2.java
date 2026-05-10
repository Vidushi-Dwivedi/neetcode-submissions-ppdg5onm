class Solution {
    class Edge {
        String to;
        double value;
        Edge(String to, double value) {
            this.to = to;
            this.value = value;
        }
    }

    public double dfs(String v1, String v2, Map<String, Boolean> visited, double[] values,
        Map<String, List<Edge>> adj) {
        visited.put(v1, true);

        if(v1.equals(v2)){
            return 1.0;
        }

        for (Edge e : adj.get(v1)) {
            if (visited.containsKey(e.to)) {
                continue;
            }

            double sub = dfs(e.to, v2, visited, values, adj);

            if(sub != -1){
                return e.value * sub;
            }
        }

        return -1.0;
    }

    public double[] calcEquation(
        List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Edge>> adj = new HashMap<>();
        double[] ans = new double[queries.size()];

        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            adj.putIfAbsent(eq.get(0), new ArrayList<>());
            adj.putIfAbsent(eq.get(1), new ArrayList<>());

            adj.get(eq.get(0)).add(new Edge(eq.get(1), values[i]));
            adj.get(eq.get(1)).add(new Edge(eq.get(0), 1 / values[i]));
        }

        for(String s: adj.keySet()){
            adj.get(s).add(new Edge(s, 1.0));
        }

        int i = 0;
        for (List<String> query : queries) {
            String v1 = query.get(0);
            String v2 = query.get(1);

            if (adj.containsKey(v1) && adj.containsKey(v2)) {
                Map<String, Boolean> visited = new HashMap<>();
                ans[i++] = dfs(v1, v2, visited, values, adj);
            } else {
                ans[i++] = -1.0;
            }
        }

        return ans;
    }
}