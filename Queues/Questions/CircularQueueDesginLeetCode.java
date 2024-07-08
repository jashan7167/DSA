class MyCircularQueue {
  private int front;
  private int rear;
  private int maxSize;
  private int[] queue;

  public MyCircularQueue(int k) {
    this.maxSize = k;
    this.front = -1;
    this.rear = -1;
    this.queue = new int[k];
  }

  public boolean enQueue(int value) {

    if (isEmpty()) {
      front = 0;
      rear = 0;
      queue[rear] = value;
      return true;
    } else {
      if (!isFull()) {
        rear = (rear + 1) % maxSize;
        queue[rear] = value;
        return true;
      } else {
        return false;
      }
    }
  }

  public boolean deQueue() {
    if (isEmpty()) {
      return false;
    } else {
      if (front == rear) {
        front = -1;
        rear = -1;
      } else {
        front = (front + 1) % maxSize;
      }
      return true;
    }
  }

  public int Front() {
    if (isEmpty()) {
      return -1;
    } else {
      return queue[front];
    }
  }

  public int Rear() {
    if (isEmpty()) {
      return -1;
    } else {
      return queue[rear];
    }
  }

  public boolean isEmpty() {
    if (front == -1 && rear == -1) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isFull() {
    if ((rear + 1) % maxSize == front || front == 0 && rear == maxSize - 1) {
      return true;
    } else {
      return false;
    }
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