package dp;

/**
 * Given two strings find the minimum number of operations to convert the first string into the
 * second string.
 * The operations are:
 * 1. Insert
 * 2. Replace
 * 3. Remove
 * recurrence relation: C(i,j) = {i, if j=0}
 *                               {j, if i =0}
 *                               {min(C(i, j-1), C(i-1, j), C(i-1, j-1)}
 */
public class EditDistance {

  static int editDistance(char[] s, char[] t, int i, int j) {
    if(i == 0) return j;
    if(j == 0) return i;

    if(s[i-1] == t[j-1]) {
      return editDistance(s, t, i-1, j-1);
    }
    else {
      return 1 + Math.min(editDistance(s, t, i-1, j),
              Math.min(editDistance(s, t, i, j-1), editDistance(s, t, i-1, j-1)));
    }
  }

  static int bottomUpEditDistance(char[] s, char[] t) {
    int m = s.length;
    int n = t.length;

    int[][] dp = new int[m+1][n+1];

    for(int i=0; i<=m; i++){
      for(int j=0; j<=n; j++) {
        if(i == 0) {
          dp[i][j] = j;
        }

        else if(j == 0) {
          dp[i][j] = i;
        }

        else if(s[i-1] == t[j-1]) {
          dp[i][j] = dp[i-1][j-1];
        }
        else {
          dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
        }
      }
    }

    return dp[m][n];
  }

  public static void main(String[] args) {
    String s1 = "sunday";
    String s2 = "saturday";

    //System.out.println(editDistance(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
    System.out.println(bottomUpEditDistance(s1.toCharArray(), s2.toCharArray()));
  }
}
