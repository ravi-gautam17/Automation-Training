import java.util.Scanner;

public class StringOperationsDemo {

  
    public static void main(String[] args) {

       String s1 = "Ravi Gautam";
       String s2 = "java";


     System.out.println("Length: " + s1.length());

     System.out.println("Is Empty: " +  s1.isEmpty());


     System.out.println("Char at index 1: " + s1.charAt(1));


     //StringBuilder sb = new StringBuilder("Builder");
     System.out.println("toString(): " + sb.toString());



     System.out.println("Equals: " + s2.equals("Java"));



     System.out.println("CompareTo: " + s2.compareTo("Java"));


     System.out.println("Contains 'Java': " +s1.contains("Singh"));

     System.out.println("IndexOf 'a': " + s1.indexOf('a'));


     System.out.println("LastIndexOf 'a': " + s1.lastIndexOf('a'));


     System.out.println("StartsWith ' Hello': " + s1.startsWith("Sarthak"));



     System.out.println("EndsWith 'World ': " +  s1.endsWith("Rathore"));


     System.out.println("Substring: " + s1.substring(1, 6));

     System.out.println("Lowercase: " + s1.toLowerCase());

     System.out.println("Trimmed: " + s1.trim() + "'");


     System.out.println("Replace: " + s1.replace("Rathore", "Rathord"));


 

        int num = 100;
        String numStr = String.valueOf(num);
        System.out.println("ValueOf: " + numStr);




        }
}
