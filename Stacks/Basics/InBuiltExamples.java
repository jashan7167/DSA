package Stacks.Basics;

import java.util.Stack;

class InBuildExamples {

  public static void main(String[] args) {

    Stack<Integer> stack = new Stack<>();

    // pushing the items into the stack
    stack.push(10);
    stack.push(11);
    stack.push(12);
    stack.push(13);
    stack.push(14);
    stack.push(15);

    // pop return an integer
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }

}
