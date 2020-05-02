public class CircularQueue {
    int front;
    int rear;
    int[] queue;
    int size;

    public CircularQueue(int k) {
        this.queue = new int[k];
        size = k;
        front = -1;
        rear = -1;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        }
        else {
            rear = (rear + 1) % size;
        }
        queue[rear] = value;
        return  true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        else {
            front = (front + 1) % size;
        }
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[rear];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return front == -1;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (front == 0 && rear == size - 1) || (front == rear + 1);
    }
}
