import java.util.*;

public class HashmapFinal<K, V> {

  ArrayList<LinkedList<Entity>> list;
  private int size = 0;

  // it means if there are 100 elements at the 51st element the size of the list
  // is going to be doubled
  private float loadFactor = 0.5f;

  public HashmapFinal() {
    list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      list.add(new LinkedList<>());
    }
  }

  public void put(K key, V value) {
    int hash = Math.abs(key.hashCode() % list.size());
    // get the linked list at hash value
    LinkedList<Entity> entities = list.get(hash);

    for (Entity entity : entities) {
      if (entity.key.equals(key)) {
        entity.value = value;
        return;
      }
    }

    if ((float) (size) / list.size() > loadFactor) {
      reHash();
    }
    entities.add(new Entity(key, value));
    size++;
  }

  private void reHash() {
    System.out.println("Rehashing");

    ArrayList<LinkedList<Entity>> old = list;
    list = new ArrayList<>();

    size = 0;

    for (int i = 0; i < old.size() * 2; i++) {
      list.add(new LinkedList<>());
    }

    for (LinkedList<Entity> entries : old) {
      for (Entity entry : entries) {
        put(entry.key, entry.value);
      }

    }

  }

  public V get(K key) {
    int hash = Math.abs(key.hashCode() % list.size());
    LinkedList<Entity> entities = list.get(hash);
    for (Entity entity : entities) {
      if (entity.key.equals(key)) {
        return entity.value;
      }
    }
    return null;
  }

  public void remove(K key) {
    int hash = Math.abs(key.hashCode() % list.size());
    LinkedList<Entity> entities = list.get(hash);

    Entity target = null;

    for (Entity entity : entities) {
      if (entity.key.equals(key)) {
        target = entity;
        break;
      }
    }
    entities.remove(target);
    size--;
  }

  public boolean containsKet(K key) {
    return get(key) != null;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("{");
    for (LinkedList<Entity> entities : list) {
      for (Entity entity : entities) {
        builder.append(entity.key);
        builder.append("=");
        builder.append(entity.value);
        builder.append(",");
      }
    }

    builder.append("}");
    return builder.toString();
  }

  private class Entity {
    K key;
    V value;

    public Entity(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  public static void main(String[] args) {
    HashmapFinal<String, String> hm = new HashmapFinal<>();

    hm.put("Mango", "Sweet");
    hm.put("Litchi", "Sour");
    hm.put("Peanut", "Salty");

    System.out.println(hm.get("Mango"));

  }

}
