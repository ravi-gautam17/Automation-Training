class BasicMathOperation{


        static  int add(int a, int b){
                return a+b;
           }


         static int subtract(int a, int b){
                return a-b;
         }

         static int multiply(int a, int b){
                return a*b;
          }

         static double divide(int a, int b){
                if(b==0){
                       throw new ArithmeticException("Division by zero");
                }
          return (double) a/b;
          }


          static int remainder(int a, int b){
                 return a% b;
           }

            static int square(int a){
                    return a*a;
            }

           static int cube(int a){
                    return a*a*a;
           }


          static  int absolute(int a){
                  return Math.abs(a);
           }



          public static void main(String[] args){
                          System.out.println(add(5,3));
                          System.out.println( square(4));
                          System.out.println( subtract(4, 2));
                          System.out.println( multiply(4, ));
                          System.out.println( divide(4, 2));
                          System.out.println( remainder(4, 2));
                          System.out.println(cube(4));
                          System.out.println( absolute(4.5));

 
          }
}