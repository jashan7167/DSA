package Queues.Basics;

public class Circularqueue {

  int[] data;
  private static final int DEFAULT_SIZE = 10;

  int end = 0;
  int front = 0;
  private int size = 0;

  public Circularqueue(int size) {
    this.data = new int[size];
  }

  public Circularqueue() {
    this(DEFAULT_SIZE);
  }

  public boolean isFull() {
    return size == data.length; // as the end pointer can go from the end to the zero we can rely upon that for
                                // the queue being full
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean insert(int item) throws Exception {
    if (isFull()) {
      throw new Exception("Queue is full");
    }
    data[end] = item;
    end = (end + 1) % data.length;
    size++;
    System.out.println("Front: " + front + "End: " + end);
    return true;
  }

  public int remove() throws Exception {
    if (isEmpty()) {
      throw new Exception("Queue is full");
    }
    int removed = data[front];
    front = (front + 1) % data.length;
    size--;
    System.out.println("Front: " + front + "End: " + end);
    return removed;
  }

  public void display() {
    int temp = front;
    do {
      System.out.println(data[temp]);
      temp = (temp + 1) % data.length;

    } while (temp != end);
  }
}
