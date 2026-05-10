class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> parent = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        // Initialize
        for (List<String> acc : accounts) {
            String name = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                parent.putIfAbsent(acc.get(i), acc.get(i));
                emailToName.put(acc.get(i), name);
            }
        }

        // Union
        for (List<String> acc : accounts) {
            String first = acc.get(1);
            for (int i = 2; i < acc.size(); i++) {
                union(first, acc.get(i), parent);
            }
        }

        // Group by root
        Map<String, List<String>> map = new HashMap<>();

        for (String email : parent.keySet()) {
            String root = find(email, parent);
            map.putIfAbsent(root, new ArrayList<>());
            map.get(root).add(email);
        }

        // Build result
        List<List<String>> res = new ArrayList<>();

        for (String root : map.keySet()) {
            List<String> emails = map.get(root);
            Collections.sort(emails);

            List<String> temp = new ArrayList<>();
            temp.add(emailToName.get(root));
            temp.addAll(emails);

            res.add(temp);
        }

        return res;
    }

    private String find(String x, Map<String, String> parent) {
        if (!parent.get(x).equals(x)) {
            parent.put(x, find(parent.get(x), parent));
        }
        return parent.get(x);
    }

    private void union(String a, String b, Map<String, String> parent) {
        String rootA = find(a, parent);
        String rootB = find(b, parent);

        if (!rootA.equals(rootB)) {
            parent.put(rootA, rootB);
        }
    }
}