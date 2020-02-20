package dp;

import java.util.Arrays;

/**
 * Count the minimum number ways you can use a set of coins to get a target sum N
 */
public class CoinChangeMin {

  public static int count(int[] dp, int[] nums, int N) {

    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for(int i=1; i<=N; i++)
      for (int j=0;j<nums.length; j++) {

          if(i - nums[j] < 0) continue;
          dp[i] = Math.min(dp[i], dp[i-nums[j]]) + 1;

      }

    return dp[N];
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 5};
    int N = 11;

    int[] dp = new int[N+1];
    System.out.println(count(dp, nums, N));
  }
}
