import java.util.*;

public class HashtableDemo {
    public static void main(String[] args) {

        // Constructors
        Hashtable<Integer, String> ht1 = new Hashtable<>();
        Hashtable<Integer, String> ht2 = new Hashtable<>(20);
        Hashtable<Integer, String> ht3 = new Hashtable<>(20, 0.75f);
        
        //  Methods
       System.out.println( ht1.put(1, "Java"));
       System.out.println( ht1.put(2, "Python"));
       System.out.println( ht1.putIfAbsent(3, "C++"));
       System.out.println( ht1.get(1));
       System.out.println( ht1.containsKey(2));
       System.out.println( ht1.containsValue("Java"));
       System.out.println( ht1.remove(2));
       System.out.println( ht1.replace(1, "Advanced Java"));
       System.out.println( ht1.keySet());
       System.out.println( ht1.values() );
        System.out.println(ht1.entrySet());
       System.out.println( ht1.size()  );
       System.out.println( ht1.isEmpty() );
       System.out.println( ht1.clone() );
       System.out.println( ht1.clear());

        System.out.println(ht1);
    }
}
