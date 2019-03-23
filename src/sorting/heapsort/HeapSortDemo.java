package sorting.heapsort;

public class HeapSortDemo {

    public static void main(String[] args) {

        Comparable a[] = {'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};

        Heap.sort(a);
        for (int i=0; i< a.length; i++)
            System.out.println(a[i]);
    }
}
