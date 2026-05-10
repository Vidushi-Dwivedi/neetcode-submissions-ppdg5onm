class MyHashSet {
    HashMap<Integer, Boolean> hashSet;

    public MyHashSet() {
        hashSet = new HashMap<>();
    }
    
    public void add(int key) {
        hashSet.putIfAbsent(key, true);
    }
    
    public void remove(int key) {
        if(hashSet.containsKey(key)){
            hashSet.remove(key);
        }
    }
    
    public boolean contains(int key) {
        return hashSet.containsKey(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */