import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {

        // Constructors
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>(20);

        // Methods
       System.out.println( list1.add("Java") );
        System.out.println(list1.add("Python") );
        System.out.println(list1.add("C++") );

        System.out.println(list1.add(1, "JS") );
        System.out.println(list1.addAll(list3) );
        System.out.println(list1.remove("Python") );
        System.out.println(list1.remove(0) );
        System.out.println(list1.set(0, "TypeScript") );
        System.out.println(list1.get(1) );
        System.out.println(list1.contains("C++") );
        System.out.println(list1.size() );
        System.out.println(list1.isEmpty() );
        System.out.println(list1.indexOf("C++") );
        System.out.println(list1.lastIndexOf("C++") );
        System.out.println(list1.clear() );

        System.out.println(list1);
    }
}
