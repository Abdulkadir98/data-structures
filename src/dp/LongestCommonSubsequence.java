package dp;

public class LongestCommonSubsequence {

  static int lcs(int i, int j, char[] s, char[] t) {
    if (i == 0 || j == 0) return 0;

    if (s[i-1] == t[j-1]) {
      return 1 + lcs(i-1, j-1, s, t);
    }
    else {
      return Math.max(lcs(i-1, j, s, t), lcs(i, j-1, s, t));
    }
  }

  static int bottomUpLCS(char[] s, char[] t) {

    int M = s.length;
    int N = t.length;

    int[][] dp = new int[M+1][N+1];

    for (int i=1; i<=M; i++){
      for (int j=1; j<=N; j++){
        if(s[i-1] == t[j-1]) {
          dp[i][j] = 1 + dp[i-1][j-1];
        }
        else if(dp[i-1][j] >= dp[i][j-1]) {
          dp[i][j] = dp[i-1][j];
        }
        else {
          dp[i][j] = dp[i][j-1];
        }
      }
    }
    return dp[M][N];
  }

  public static void main(String[] args) {

    String s = "ABCBDAB";
    String t = "BDCABA";

    //System.out.println(lcs(s.length(), t.length(), s.toCharArray(), t.toCharArray()));
    System.out.println(bottomUpLCS(s.toCharArray(), t.toCharArray()));
  }
}
