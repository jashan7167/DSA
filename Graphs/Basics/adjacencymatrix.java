import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class AM {
  public static void main(String[] args) {
    Scanner sf = new Scanner(System.in);
    int edges, vertices;

    System.out.println("Enter the no of edges: ");
    edges = sf.nextInt();
    System.out.println("Enter the no of vertices: ");
    vertices = sf.nextInt();

    int adj[][] = new int[edges + 1][vertices + 1];

    // edges 1-2
    adj[1][2] = 1;
    adj[2][1] = 1;

    // edges 2--3
    adj[2][3] = 1;
    adj[2][1] = 1;

    // edges 1-3
    adj[1][3] = 1;
    adj[3][1] = 1;

  

  }
}