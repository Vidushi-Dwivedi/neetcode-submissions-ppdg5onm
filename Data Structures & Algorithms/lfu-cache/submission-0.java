class LFUCache {
    private static class Node {
        int key, value, freq;
        Node prev, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1; // All new nodes start with a frequency of 1
        }
    }

    private static class DoublyLinkedList {
        Node head, tail;
        int size;
        
        DoublyLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addFront(Node node) {
            node.next = head.next;
            node.next.prev = node;
            head.next = node;
            node.prev = head;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeTail() {
            if (size == 0) return null;
            Node lru = tail.prev;
            remove(lru);
            return lru;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Map<Integer, DoublyLinkedList> freqMap;
    private int minFrequency;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.minFrequency = 0;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        updateFrequency(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            updateFrequency(node);
        } else {
            if (cache.size() == capacity) {
                // Evict the LRU node from the minimum frequency list
                DoublyLinkedList minList = freqMap.get(minFrequency);
                Node deadNode = minList.removeTail();
                cache.remove(deadNode.key);
            }
            
            // Insert brand new node
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            minFrequency = 1; // Reset global min frequency to 1
            
            freqMap.putIfAbsent(1, new DoublyLinkedList());
            freqMap.get(1).addFront(newNode);
        }
    }

    // 5. Helper to increment node frequency and shift buckets
    private void updateFrequency(Node node) {
        int oldFreq = node.freq;
        DoublyLinkedList oldList = freqMap.get(oldFreq);
        oldList.remove(node);
        
        // If the min frequency list becomes empty, increment global minFrequency
        if (oldFreq == minFrequency && oldList.size == 0) {
            minFrequency++;
        }
        
        node.freq++;
        freqMap.putIfAbsent(node.freq, new DoublyLinkedList());
        freqMap.get(node.freq).addFront(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */