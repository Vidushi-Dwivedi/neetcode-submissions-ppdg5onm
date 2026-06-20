class MyCircularQueue {
    private final int[] queue;
    int head, tail;
    int size, capacity;
    public MyCircularQueue(int k) {
        capacity = k;
        size = 0;
        head = -1;
        tail = -1;
        queue = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(size == capacity){
            return false;
        }

        if(head == -1 && tail == -1){
            head = 0;
            tail = 0;
        } else{
            tail = (tail + 1) % capacity;
        }

        queue[tail] = value;
        size++;

        return true;
    }
    
    public boolean deQueue() {
        if(size == 0){
            return false;
        }

        queue[head] = 0;
        head = (head + 1) % capacity;
        size--;

        return true;
    }
    
    public int Front() {
        if(size == 0){return -1;}

        return queue[head];
    }
    
    public int Rear() {
        if(size == 0) {return -1;}

        return queue[tail];
    }
    
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }

        return false;
    }
    
    public boolean isFull() {
        if(size == capacity){ return true;}

        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */