class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        //Create adjacency list
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        List<String> result = new ArrayList<>();

        for(List<String> lst : tickets){
            adj.putIfAbsent(lst.get(0), new PriorityQueue<String>());
            adj.get(lst.get(0)).add(lst.get(1));
        }
        // System.out.println(adj.get("JFK"));

        if(!adj.get("JFK").isEmpty()){
            dfs("JFK", adj, result);
        }

        return result;
    }

    public void dfs(String key, Map<String, PriorityQueue<String>> adj, List<String> result){
        PriorityQueue<String> pq = adj.get(key);

        while(pq!=null && !pq.isEmpty()){
            String cur = pq.poll();
            dfs(cur, adj, result);
        }

        result.add(0, key);
    }
}