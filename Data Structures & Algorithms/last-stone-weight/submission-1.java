class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for(int x: stones){
            pq.offer(x);
        }

        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            
            if(a != b){
                pq.offer((a > b? (a - b) : (b - a)));
            }
        }

        return pq.isEmpty()? 0: pq.peek();
    }
}
