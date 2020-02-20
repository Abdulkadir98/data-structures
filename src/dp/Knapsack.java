package dp;

import java.util.Arrays;

/**
 * Given a list of items with size and value and a knapsack with size S, maximize the values of the
 * items that can be kept inside the knapsack
 */
public class Knapsack {

  /**
   * recursive method to calculate the max value
   * @param itemValues the array of values of each item
   * @param itemWeights the array of weights of each item
   * @param W the weight of the knapsack
   * @param n the length of the weights and values array
   * @return the max value
   */
  public static int max(int[] itemValues, int[] itemWeights, int W, int n, int[] dp) {

    if(n == 0 || W == 0) {
      dp[n] = n;
      return dp[n]; // Base case
    }

    if (itemWeights[n-1] > W) {
      return max(itemValues, itemWeights, W, n-1, dp);
    }
    else {

      if(dp[n] > -1) {
        return dp[n];
      }
      dp[n] =  Math.max(itemValues[n-1] + max(itemValues, itemWeights, W - itemWeights[n-1], n-1, dp),
              max(itemValues, itemWeights, W, n-1, dp));

      return dp[n];
    }
  }

  /**
   * Bottom-up Dynamic programming solution
   * @param
   */

  public static int knapsackBottomup(int[] itemValues, int[] itemWeights, int W) {
    int N = itemValues.length;

    int[][] dp = new int[N+1][W+1];

    for (int i=1; i<=N; i++)
      for (int w=1; w <= W; w++) {

        if(itemWeights[i-1] > w) {
          dp[i][w] = dp[i-1][w];
        }
        else {
          dp[i][w] = Math.max(itemValues[i-1] + dp[i-1][w - itemWeights[i-1]], dp[i-1][w]);
        }
      }
    return dp[N][W];
  }


  public static void main(String[] args) {
    int[] vals = {60, 100, 120};
    int[] weights = {10, 20, 30};
    int weight = 50;

    int n = vals.length;
    int[] dp = new int[n+1];
    Arrays.fill(dp, -1);

    System.out.println(knapsackBottomup(vals, weights, weight));
  }
}
