package sorting.quicksort;

public class QuickSortDemo {

    public static void main(String[] args) {

        Comparable[] a = {'Q', 'U', 'I', 'C', 'K', 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
        Quick.sort(a);

        for (Comparable val: a){
            System.out.println(val);
        }
    }
}
