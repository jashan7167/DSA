package Basics;

public class QueueMain {
  public static void main(String[] args) throws Exception{

    // Queue q = new Queue(5);

    // q.insert(1);
    // q.insert(2);
    // q.insert(3);
    // q.insert(4);
    // q.insert(5);
    // q.remove();
    // q.remove();

    // q.display();

    Circularqueue cq = new Circularqueue(5);
    cq.insert(1);
    cq.insert(2);
    cq.insert(3);
    cq.insert(4);
    cq.insert(5);
    cq.remove();
    cq.remove();
    cq.remove();
    cq.remove();
    cq.insert(6);
    cq.display();
  }


}
