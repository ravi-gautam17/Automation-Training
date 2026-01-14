import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {

        //  Constructors
        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>(20);


        //  Methods
       System.out.println( map1.put(1, "Java"));
       System.out.println( map1.put(2, "Python"));
       System.out.println( map1.putIfAbsent(3, "C++"));
       System.out.println( map1.get(1));
       System.out.println( map1.getOrDefault(4, "NA"));
       System.out.println( map1.containsKey(2));
       System.out.println( map1.containsValue("Java"));
      System.out.println(  map1.remove(2));
      System.out.println(  map1.replace(1, "Advanced Java"));
       System.out.println( map1.keySet());
       System.out.println( map1.values());
       System.out.println( map1.entrySet());
       System.out.println( map1.size());
       System.out.println( map1.isEmpty());
       System.out.println( map1.clear());

        System.out.println(map1);
    }
}
