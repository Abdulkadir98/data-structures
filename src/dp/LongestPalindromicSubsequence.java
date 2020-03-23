package dp;

/**
 * Given a Sequence find the longest palindromic subsequence
 * Recurrence relation: LC(i,j) = {1, i = j}
 *                                {max(lcs(s, i+1, j), lcs(s, i, j-1))}
 */
public class LongestPalindromicSubsequence {

  // naive recursive solution
  static int lps(char[] s, int i, int j) {

    if(i == j) return 1;  // same character is a palindrome

    if(s[i] == s[j] && i+1 == j ) return 2;

    if(s[i] == s[j]) {
      return lps(s, i+1, j-1) + 2;
    }

    return Math.max(lps(s, i+1, j), lps(s, i, j-1));
  }

  static int bottomUpLps(char[] s) {
    int n = s.length;
    int[][] dp = new int[n][n];

    for(int i=0; i<n; i++)
      dp[i][i] = 1;

    // The table is filled similar to parenthesization. The entries below the main diagonal are
    // ignored and not computed

      for(int l=2; l<=n; l++) {
        for(int i=0; i<n-l+1; i++) {
          int j = i+l-1;

          if(s[i] == s[j] && l == 2) {
            dp[i][j] = 2;
          }
          else if(s[i] == s[j]) {
            dp[i][j] = dp[i+1][j-1] + 2;
          }
          else{
            dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
          }
        }
      }


    return dp[0][n-1];
  }

  public static void main(String[] args) {
    String s = "bbbab";

    //System.out.println(lps(s.toCharArray(), 0, s.length()-1));
    System.out.println(bottomUpLps(s.toCharArray()));
  }
}
