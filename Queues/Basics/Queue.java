package Queues.Basics;

public class Queue extends Exception {
  // queues can have two ptrs front and rear add at the back and remove from the
  // first but thats the easy approach we have to be better

  private int[] data;
  private static final int DEFAULT_SIZE = 10;

  int end = -1;

  public Queue(int size) {
    this.data = new int[size];
  }

  public Queue() {
    this(DEFAULT_SIZE); // another use case of this is that it can also call other constructor which
                        // accepts the size parameter
  }

  public boolean isFull() {
    return end == data.length - 1; // if its full then top is equal to the index of length - 1
  }

  public boolean isEmpty() {
    return end == -1;
  }

  public boolean insert(int item) {
    if (isFull()) {
      return false; // as its return we dont need the else statement when return statement is
                    // executed it will return and not go further
    }
    end++;
    data[end] = item;
    return true;
  }

  public int remove() throws Exception {
    if (isEmpty()) {
      throw new Exception("Queue is full");
    }
    int item = data[0];
    // shifting the items to the right to move the queue
    for (int i = 0; i < end; i++) {
      data[i] = data[i + 1];
    }
    end--;

    return item;
  }

  public void display() {
    for (int i = 0; i <= end; i++) {
      System.out.print(data[i] + " ");
    }
    System.out.println("end");
  }

}
