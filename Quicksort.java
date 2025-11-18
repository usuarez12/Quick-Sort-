package Quicksort;

public class Quicksort {

   public static void quickcsort (int [] a, int low, int high){
        if( low < high) {
            int p = partition(a, low, high);
            quickcsort(a, low, p - 1);
            quickcsort(a, p + 1, high);

        }
   }

   
  
  



} 