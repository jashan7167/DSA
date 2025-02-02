package Basics;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class inBuiltExamples {

  public static void main(String[] args) {
    //as queue is an interface we cannot
    Queue<Integer> q = new LinkedList<>();
    q.add(3);
    q.add(4);
    q.add(5);
    q.add(6);
    q.add(7);

    //peek gets the item but doesnot remove it
    System.out.println(q.peek());

    //remove will remove 3
    System.out.println(q.remove());

    //after removing the first element

    System.out.println(q.peek());


    //Deque
    Deque<Integer> deq = new ArrayDeque<>();
    deq.add(89);
    deq.addLast(78);
    deq.addLast(79);
    deq.addLast(80);
    deq.removeFirst();
    System.out.println(deq.peek());




  }

}
