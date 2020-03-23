package dp;

/**
 * Given a rod of length N and array of prices for each cut of i inches of rod, find the maximum
 * price of the cuts that can be made of the rod
 *
 * Recurrence relation: T(n) = {0 when n=0,}
 *                             {Pi + T(n-i)}
 */
public class RodCutting {

  static int memoizedCutRod (int[] prices, int n, int[] dp) {

    if(n == 0) {
      dp[n] = 0;
      return dp[n];
    }

    if(dp[n] > 0) {
      return dp[n];
    }

    int max = Integer.MIN_VALUE;
    for (int i=0; i<n; i++) {
      max = Math.max(max, prices[i] + memoizedCutRod(prices,n-i-1, dp));
    }

    dp[n] = max;
    return dp[n];
  }

  static int bottomUpCutRod(int[] prices) {
    int n = prices.length;
    int[] dp = new int[n+1];
    for (int j=1; j<=n; j++) {
      int max = Integer.MIN_VALUE;
      for (int i=0; i<j; i++){
        max = Math.max(max, prices[i] + dp[j-i-1]);
        dp[j] = max;
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {

    int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
    int[] dp = new int[prices.length+1];
    System.out.println(bottomUpCutRod(prices));
  }
}
