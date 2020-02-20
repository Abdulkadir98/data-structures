package dp;

import java.util.Arrays;

/**
 * Given 2 X N board count the number of ways you can tile the board using 2 X 1 Tiles
 * Recurrence: T(1) = 1
 *           : T(2) = 2
 *             T(N) = count(n-1) + count(n-2) (same as fibonacci numbers)
 */
public class TilingProblem {

  // Top-down memoized version
  public static int count(int N, int[] memo) {
    if(N == 1 || N == 2) return N;

    if(memo[N] > 0) {
      return memo[N];
    }

    int count = count(N-1, memo) + count(N-2, memo);
    memo[N] = count;

    return memo[N];
  }

  public static void main(String[] args) {

    int[] memo = new int[5];
    Arrays.fill(memo, 0);
    System.out.println(count(4, memo));
  }
}
