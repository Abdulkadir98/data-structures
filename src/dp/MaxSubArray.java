package dp;

/**
 * Find the max sum subarray using Kadane's algorithm
 * max(i) = {max(A[i], A[i] + local_max[i-1]}
 */
public class MaxSubArray {

  public static void main(String[] args) {
    int[] arr = {-1, 2, -3, 4, -1, 2, 1, -5, 4};

    int localMax = 0;
    int globalMax = Integer.MIN_VALUE;

    for (int i = 0; i < arr.length ; i++) {
      localMax = Math.max(arr[i], arr[i] + localMax);
      if (localMax > globalMax) {
        globalMax = localMax;
      }
    }

    System.out.println(globalMax);
  }
}
