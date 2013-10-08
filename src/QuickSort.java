import java.util.Arrays;
import java.util.Collections;

@SuppressWarnings("rawtypes")
public class QuickSort {

    public static void main(String[] args) {
        Integer[] input = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(input));
        sort(input);
        System.out.println(Arrays.toString(input));
 
    }

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);

    }

    private static int partition(Comparable[] a, int lo, int hi) {

        int i = lo, j = hi + 1;

        while (true) {
            while (less(a[++i], a[lo])) {
                if (i == hi)
                    break;
            }

            while (less(a[lo], a[--j])) {
                if (j == lo)
                    break;
            }

            if (i >= j)
                break;
            exchange(a, i, j);
        }

        exchange(a, lo, j);
        return j;
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    @SuppressWarnings("unchecked")
    private static boolean less(Comparable a, Comparable b) {
        if (a.compareTo(b) < 0)
            return true;
        else
            return false;
    }

}
