package dp;

/**
 * In a set of numbers see if there's a subset that adds up to the target sum
 *
 */
public class SumSubset {

  private static boolean isSubsetSum(int n, int target, int[] set){
    if(target == 0) {
      return true;
    }

    if(target > 0 && n == 0){
      return false;
    }

    if(set[n-1] > target) {
      return isSubsetSum(n-1, target, set);
    }
    else {
      return isSubsetSum(n-1, target, set) || isSubsetSum(n-1, target-set[n-1], set);
    }
  }

  /**
   * Top down memoized version of the above recursive solution
   */
  private static boolean isSubsetSumTopDown(int n, int target, int[] set, boolean[] dp) {
    if(target == 0) {
      dp[n] = true;
      return dp[n];
    }

    if(n==0 && target>0) {
     return dp[n];
    }
    if(set[n-1] > target) {
      dp[n] = isSubsetSumTopDown(n-1, target, set, dp);
      return dp[n];
    }
    if(dp[n]) {
      return dp[n];
    }
    else {
      dp[n] = isSubsetSumTopDown(n-1, target, set, dp);
      return dp[n];
    }
  }

  public static void main(String[] args) {
   int[] set = {3, 34, 4, 12, 5, 2};
   int target = 9;
   boolean[] dp = new boolean[set.length+1];
    //System.out.println(isSubsetSum(set.length, 9, set));
    System.out.println(isSubsetSumTopDown(set.length, 9, set, dp));
  }
}
