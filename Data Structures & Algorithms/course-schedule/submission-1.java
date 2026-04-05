class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<Integer> ans = new ArrayList<Integer>();

        for(int[] edge : prerequisites){
            indegrees[edge[0]]++;
        }
        // for(int i: indegrees){
            
        //     System.out.println(i);
        // }

        Queue<Integer> que = new LinkedList<>();

        for(int i= 0; i< indegrees.length; i++){
            if(indegrees[i] == 0){
                que.offer(i);
            }
        }

        while(!que.isEmpty()){
            int vertex = que.poll();
            ans.add(vertex);

            for(int[] edge: prerequisites){
                if(edge[1] == vertex){
                    indegrees[edge[0]]--;
                    if(indegrees[edge[0]] == 0){
                        que.offer(edge[0]);
                    }
                }
            }
        }

        if(ans.isEmpty() || ans.size()< numCourses){
            return  false;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int i= 0;i < ans.size(); i++){
            map.put(ans.get(i), i);
        }

        for(int[] edge: prerequisites){
            int u = edge[1];
            int v = edge[0];

            int u_pos = map.get(u);
            int v_pos = map.get(v);

            if(u_pos > v_pos){
                return false;
            }
        }

        return true;
    }
}
