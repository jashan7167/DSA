

public class StackMain {
  public static void main(String[] args) throws Stackexception {
    // Stack s = new Stack(5);
    // s.push(10);
    // s.push(11);
    // s.push(12);
    // s.push(13);
    // s.push(14);
    // s.push(14);
    // System.out.println(s.peek());
    // System.out.println(s.pop());
    // System.out.println(s.pop());
    // System.out.println(s.pop());
    // System.out.println(s.pop());
    // System.out.println(s.pop());
    // System.out.println(s.pop()); //will give an exception of the empty stack
    DynamicStack ds = new DynamicStack(5);
    ds.push(10);
    ds.push(11);
    ds.push(12);
    ds.push(13);
    ds.push(14);
    ds.push(14); // as its the dynamic stack now we can insert it
    System.out.println(ds.pop());
    System.out.println(ds.pop());
    System.out.println(ds.pop());
    System.out.println(ds.pop());
    System.out.println(ds.pop());
    System.out.println(ds.pop());
  }
}