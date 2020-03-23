package dp;

/**
 * Given two strings X and Y, find the longest common substring between the two strings
 * dp[i, j] = {max(max, dp[i-1, j-1]) + 1 if s[i] == s[j] else 0}
 */
public class LongestCommonSubstring {

  public static int bottomUpLCSuff(String a, String b) {

    int m = a.length();
    int n = b.length();

    int ans = Integer.MIN_VALUE;

    int[][] dp = new int[m+1][n+1];

    for(int i=1; i<=m; i++){
      for(int j=1; j<=n; j++) {
        if(a.charAt(i-1) == b.charAt(j-1)) {
          dp[i][j] = 1 + dp[i-1][j-1];
          ans = Math.max(ans, dp[i][j]);
        }
        else {
          dp[i][j] = 0;
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    String a = "GeeksforGeeks";
    String b = "GeeksQuiz";

    System.out.println(bottomUpLCSuff(a, b));
  }
}
