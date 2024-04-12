package Stacks.Basics;

public class Stack {
  protected int[] data; // this is an array which have defined length and get full
  private static final int DEFAULT_SIZE = 10;
  int top = -1;

  public Stack(int size) {
    this.data = new int[size];
  }

  public Stack() {
    this(DEFAULT_SIZE); // another use case of this is that it can also call other constructor which
                        // accepts the size parameter
  }

  public boolean push(int item) {
    if (isFull()) {
      System.out.println("Stack is full!!!");
      return false;
    }
    top++;
    data[top] = item;
    return true;
  }

  public int pop() throws Stackexception {
    if (isEmpty()) {
      throw new Stackexception("cannot pop from an empty stack"); // create the expection object to be catched
    }
    int removed = data[top];
    top--;
    return removed;
  }

  public int peek() throws Stackexception {
    if (isEmpty()) {
      throw new Stackexception("cannot peek from an empty stack"); // create the expection object to be catched
    }
    int peek = data[top];
    return peek;
  }

  public boolean isFull() {
    return top == data.length - 1; // if its full then top is equal to the index of length - 1
  }

  public boolean isEmpty() {
    return top == -1;
  }

}
