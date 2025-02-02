import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Hashmap {

  public static void main(String[] args) {
    HashMap<String, Integer> hm = new HashMap<>();

    hm.put("Jashan", 90);
    hm.put("Fateh", 77);
    hm.put("Hargun", 44);
    hm.put("Archit", 50);

    // put the value doesnot exist put the default
    hm.putIfAbsent("Meet", 50);

    System.out.println(hm.get("Fateh"));

    // we can search for it and if search failed get the default value
    System.out.println(hm.getOrDefault("Meet", -1));

    System.out.println(hm.containsKey("Hargun"));

    HashSet<Integer> set = new HashSet<>();
    set.add(56);
    set.add(91);
    set.add(12);
    set.add(56);
    set.add(2);
    set.add(6);
   Iterator<Integer> itr = set.iterator();

   while(itr.hasNext())
   {
    System.out.println(itr.next());
   
   }

   //TreeMap will give the items in the sorted order
   //You can use tree map for that purpose

  }

}
