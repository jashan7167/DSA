public class Main {
  public static void main(String[] args) {
    Heap<Integer> hp = new Heap<>();

    hp.insert(23);
    hp.insert(13);
    hp.insert(10);
    hp.insert(2);
    hp.insert(5);

    try {
      System.out.println(hp.heapSort());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
