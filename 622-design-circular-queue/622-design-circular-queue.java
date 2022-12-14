class MyCircularQueue {
    
    int[] items;
    int frontIdx, rearIdx;
    int size;

    public MyCircularQueue(int k) {
        this.items = new int[k];
        this.frontIdx = 0;
        this.rearIdx = -1;
        this.size = 0;
    }

    public boolean enQueue(int value) {
        if(isFull()) return false;
        rearIdx = (rearIdx + 1) % items.length;
        items[rearIdx] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) return false;
        frontIdx = (frontIdx + 1) % items.length;
        size--;
        return true;
    }

    public int Front() {
        if(isEmpty()) return -1;
        return items[frontIdx];
    }

    public int Rear() {
        if(isEmpty()) return -1;
        return items[rearIdx];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == items.length;
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