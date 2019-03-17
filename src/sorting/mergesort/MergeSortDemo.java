package sorting.mergesort;

public class MergeSortDemo {

    public static void main(String[] args) {
     Comparable[] a = {'M', 'E', 'R', 'G', 'E', 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};

     MergeSort.sort(a);
     for (Comparable i: a) {
         System.out.println(i);
     }

    }
}
