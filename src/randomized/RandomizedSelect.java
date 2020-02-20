package randomized;

/**
 * A randomized algorithm to find the ith order statistic (ith smallest element) in an input array
 * in linear time by modifying the quick sort algorithm.
 * Running time: O(n) by master method (case 2)
 */
public class RandomizedSelect {

  public static int select(int[] arr, int order) {

    return select(arr, 0, arr.length - 1, order-1);
  }

  private static int select(int[] arr, int first, int last, int order) {
    if(first == last) return arr[first];

    int pivotIdx = partition(arr, first, last);
    if(pivotIdx == order) return arr[pivotIdx];

    if (pivotIdx > order) {
      return select(arr, first, pivotIdx-1, order);
    }
    else {
      return select(arr, pivotIdx+1, last, order+1-pivotIdx);
    }
  }

  private static int partition(int[] arr, int first, int last) {
    int pivot = arr[first];
    int i = first+1;
    for (int j=first+1; j<=last; j++) {
      if (arr[j] < pivot) {
        exch(arr, i, j);
        i++;
      }
    }

    exch(arr, first, i-1);
    return i-1;
  }

  private static void exch(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6};
    System.out.println(select(arr, 4));
  }
}
