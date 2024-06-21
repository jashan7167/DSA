import java.util.*;

public class Hashimplementation {
  private Entity[] entities;

  public Hashimplementation() {
    entities = new Entity[100];
  }

  public void put(String key, String value) {
    int hash = Math.abs(key.hashCode() % entities.length);
    entities[hash] = new Entity(key, value);

  }

  public String get(String key) {
    int hash = Math.abs(key.hashCode() % entities.length);

    if (entities[hash] != null && entities[hash].key.equals(key)) {
      return entities[hash].value;
    }
    return null;

  }

  public void remove(String key) {
    int hash = Math.abs(key.hashCode() % entities.length);
    if (entities[hash] != null && entities[hash].key.equals(key)) {
      entities[hash] = null;
    }

  }

  private class Entity {
    String key;
    String value;

    public Entity(String key, String value) {
      this.key = key;
      this.value = value;
    }

  }

  public static void main(String[] args) {
    Hashimplementation map = new Hashimplementation();
    map.put("Mango", "Sweet");
    map.put("Litchi", "Sour");
    map.put("Peanut", "Salty");

    System.out.println(map.get("Mango"));

  }

}
