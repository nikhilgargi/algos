import java.util.Arrays;

//@SuppressWarnings("rawtypes" )

public class MergeSort {

    public static void main(String[] args) {
         Integer[] input = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
         System.out.println(Arrays.toString(input));
         sort(input);
         System.out.println(Arrays.toString(input));
  
    }
    
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
    }
    
    private static void sort( Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        
        int mid = lo + (hi - lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);      
        
    }

 

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid,
            int hi) {

        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);

        // Copy
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // Merge
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[i].compareTo(aux[j]) < 0) {
                a[k] = aux[i++];
            } else
                a[k] = aux[j++];
        }

        assert isSorted(a, lo, hi);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        boolean isSorted = true;
        for (int k = lo; k < hi; k++) {
            if (a[k].compareTo(a[k + 1]) > 0) {
                isSorted = false;
                break;
            }
        }

        return isSorted;
    }
}
