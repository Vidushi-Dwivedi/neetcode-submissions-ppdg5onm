class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) return -1;
        if (target.equals("0000")) return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");
        int turns = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();  // process level by level
            turns++;
            for (int i = 0; i < size; i++) {
                String state = queue.poll();
                for (String neighbor : getNeighbors(state)) {
                    if (neighbor.equals(target)) return turns;
                    if (!visited.contains(neighbor) && !dead.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return -1;
    }

    private List<String> getNeighbors(String state) {
        List<String> result = new ArrayList<>();
        char[] arr = state.toCharArray();
        for (int i = 0; i < 4; i++) {
            char original = arr[i];
            // turn up
            arr[i] = (char)((original - '0' + 1) % 10 + '0');
            result.add(new String(arr));
            // turn down
            arr[i] = (char)((original - '0' + 9) % 10 + '0');
            result.add(new String(arr));
            // restore
            arr[i] = original;
        }
        return result;
    }
}