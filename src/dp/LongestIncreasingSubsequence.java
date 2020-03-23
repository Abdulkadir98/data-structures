package dp;

/**
 * Given an array of integers find the length of the longest increasing subsequence
 */
public class LongestIncreasingSubsequence {


  private static int lis(int[] nums, int prev, int curpos) {
    // Reached end of array, included all elements
    if(curpos == nums.length) {
      return 0;
    }
    int taken = 0;
    if(nums[curpos] > prev) {
      taken = 1 + lis(nums, nums[curpos], curpos+1);
    }
    int nottaken = 0;
    nottaken = lis(nums, nums[curpos], curpos+1);

    return Math.max(taken, nottaken);
  }

  public static void main(String[] args) {
    int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
    //System.out.println(lis(arr, Integer.MIN_VALUE, 0));
    lisbottomup(arr);
  }

  // bottom up DP
  // We find the recurive relation to be:
  // dp[i] = max(dp[j]) + 1
  // LIS(i) = max(dp[i])

  private static void lisbottomup(int[] nums) {
    int[] dp = new int[nums.length];

    int maxans = 1;
    dp[0] = 1;

    for (int i=1; i<dp.length; i++) {
      int maxval = 0;
      for(int j=0; j<i; j++) {
        if(nums[i] > nums[j]) {
          maxval = Math.max(maxval, dp[j]);
        }
      }
      dp[i] = maxval + 1;
      maxans = Math.max(maxans, dp[i]);
    }

    System.out.println(maxans);
  }
}
