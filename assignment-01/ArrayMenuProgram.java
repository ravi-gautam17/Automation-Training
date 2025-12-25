import java.util.*;
class ArrayMenuProgram{

         static int linearSearch(int[] arr, int key){

                 for(int i=0; i< arr.length; i++){
                           if(arr[i] == key) return i;
                  }

         return -1;
         }
         public static int findMax(int[] arr){

                   int max = arr[0];

                   for(int n: arr){
                          if(n > max) max = n;
                   }
                   return max;
             }

             static void insertIonSort(int[] arr){

                      for( int i=1; i< arr.length;  i++){

                              int key = arr[i];
                              int j = i-1;
                               while( j>= 0 && arr[j]  >  key){

                                       arr[j+1] = arr[j];
                                        j--;
                                }
                     arr[j+1] = key;

                     }
               }

               public static void main( String[] args){

                         int[] arr={ 5,3,8,1,2};
                         insertionSort(arr);
                         System.out.println(Arrays.toString(arr));
                          System.out.println(linearSearch(arr, 5));
                         System.out.println(findMax(arr));
             }

}