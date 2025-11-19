package quicksort;

public class Quicksort {

   public static void quickcsort (int [] a, int low, int high){
        if( low < high) {
            int p = partition(a, low, high);
            quickcsort(a, low, p - 1);
            quickcsort(a, p + 1, high);

        }
   }

    public static int partition(int[] a, int low, int high) {    
        // Agrear un pivote 
        int mid = low + (high - low) / 2;
        int pivot = a [mid];
        int i =low , j =  high;
        while(i <= j) {
            while(a[i]< pivot) i++;
            while(a[j]>pivot) j--;
            if(i <=j) {
                swap(a, i, j);
                i++;
                j--;
            }
        } return i;
    }
    
   
    
  



} 