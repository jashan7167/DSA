import java.util.ArrayList;

class Heap<T extends Comparable<T>> {

  private ArrayList<T> list;

  public Heap() {
    list = new ArrayList<>();
  }

  private void swap(int first, int second) {
    T temp = list.get(first);
    list.set(first, list.get(second));
    list.set(second, temp);
  }

  private int parent(int index) {
    return (index - 1) / 2;
  }

  private int left(int index) {
    return (2 * index) + 1;
  }

  private int right(int index) {
    return (2 * index) + 2;
  }

  public void insert(T value) {
    list.add(value);
    upheap(list.size() - 1);
  }

  private void upheap(int index) {
    if (index == 0) {
      return;
    }

    int p = parent(index);
    // so basically with each swap recursively call upheap again until and the
    // parent is greater than the value
    if (list.get(index).compareTo(list.get(p)) < 0) {
      swap(index, p);
      upheap(p);
    }
  }

  public T remove() throws Exception {
    if (list.isEmpty()) {
      throw new Exception("removing from empty heap");
    }

    T temp = list.get(0);

    T last = list.remove(list.size() - 1);

    if (!list.isEmpty()) {
      list.set(0, last);
      downheap(0);
    }

    return temp;
  }

  private void downheap(int index) {
    int min = index;
    int left = left(index);
    int right = right(index);

    if (left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
      min = left;
    }
    if (right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
      min = right;
    }

    // when this happens we have found a element that is smaller than left or right
    // hence we need to set the min index as the smaller of two and call the down
    // heap on that to stabalise the heap until children are greater than the root

    if (min != index) {
      swap(min, index);
      downheap(min);
    }

  }

  public ArrayList<T> heapSort() throws Exception {
    int i = 0;
    ArrayList<T> ls = new ArrayList<>();
    while (!list.isEmpty()) {
      ls.add(remove());
    }
    return ls;
  }
}