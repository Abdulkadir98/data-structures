package sorting.radixsort;

/**
 * Least Significant digit String sort
 * Time Complexity: O(W * N) where W is String length and N is number of strings
 */
public class LSD {

    public static void sort(String a[], int W) {
        int R = 256;
        int N = a.length;
        String[] aux = new String[N];

        for (int d = W-1; d>=0; d--) {
            int[] count = new int[R+1];

            for (int i=0; i<N; i++) {
                count[a[i].charAt(d) + 1]++; //key-indexed counting
            }

            for(int r=0; r<R; r++)
                count[r+1] += count[r];

            for (int i=0; i<N; i++)
                aux[count[a[i].charAt(d)]++] = a[i];

            for (int i=0; i<N; i++)
                a[i] = aux[i];
        }

    }

    public static void main(String[] args) {

        String[] words = {"fad", "bed", "map", "fee", "sat", "bot", "eat"};
        sort(words, 3);
        for (String word: words)
            System.out.println(word);

    }
}
