import java.util.*;

public class VectorDemo {
    public static void main(String[] args) {

        //  Constructors
        Vector<Integer> v1 = new Vector<>();
        Vector<Integer> v2 = new Vector<>(10);
        Vector<Integer> v3 = new Vector<>(10, 5);

        //  Methods
       System.out.println( v1.add(10) );
       System.out.println( v1.addElement(20) );
       System.out.println( v1.add(30) );
        System.out.println(v1.insertElementAt(15, 1) );
       System.out.println( v1.removeElement(20) );
       System.out.println( v1.remove(0) );
       System.out.println( v1.get(0) );
       System.out.println( v1.set(0, 100) );
       System.out.println( v1.size() );
       System.out.println( v1.capacity() );
       System.out.println( v1.contains(100) );
       System.out.println( v1.indexOf(30) );
       System.out.println( v1.firstElement() );
       System.out.println( v1.lastElement() );
       System.out.println( v1.clear();

        System.out.println(v1);
    }
}
