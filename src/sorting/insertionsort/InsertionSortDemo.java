package sorting.insertionsort;

public class InsertionSortDemo {

    public static void main(String[] args) {

        Comparable[] a = {'E', 'X', 'A', 'M', 'P', 'L', 'E'};
        Insertion.sort(a);

        for (Comparable key: a) {
            System.out.println(key);
        }
    }
}
