class Solution {
    public int findJudge(int n, int[][] trust) {
        List<List<Integer>> list = new ArrayList<>();
        Stack<Integer> st = new Stack<Integer>();

        for(int i = 0; i<= n; i++){
            list.add(new ArrayList<Integer>());
        }

        for(int i = 0; i< trust.length; i++){
            list.get(trust[i][0]).add(trust[i][1]);
        }

        for(int i = 1; i < list.size(); i++){
            if(list.get(i).isEmpty()){
                st.push(i);
            }
        }

        while(!st.isEmpty()){
            int mem = st.pop();
            boolean flag = true;
            for(int i = 1; i < list.size(); i++){
                if(!list.get(i).contains(mem) && i != mem){
                    flag = false;
                }
            }

            if(flag == true){
                return mem;
            }
        }

        return -1;
    }
}