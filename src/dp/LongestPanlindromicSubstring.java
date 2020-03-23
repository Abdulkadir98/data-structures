package dp;

/**
 * Given a string find the longest palindromic substring
 */
public class LongestPanlindromicSubstring {


  private static boolean isPalindrome(String s) {


    for (int i=0, j=s.length()-1; i<=j; i++, j--) {
      if(s.charAt(i) != s.charAt(j)){
        return false;
      }
    }
    return true;
  }

  // naive version
  static String longestBruteForce(String s) {

    int bestStart = -1;
    int bestEnd = -1;
    int bestLen = 0;
    int N= s.length();
    for (int L=0; L<N; L++){
      for (int R=L; R<N; R++) {
        int len = R - L + 1;
        String subs = s.substring(L, R);

        if(len > bestLen && isPalindrome(subs)) {
          bestLen = len;
          bestStart = L;
          bestEnd = R;
        }
      }
    }
    return s.substring(bestStart, bestEnd);
  }

  static String longestPalindromicSubstring(String s) {
    int N = s.length();
    int maxLen = 0;
    String ans = "";

    for (int mid = 0; mid<N; mid++) {
      for (int i=0; mid-i>=0 && mid+i<N; i++) {
        if(s.charAt(mid-i) != s.charAt(mid+i)) {
          break;
        }
        int len = 2*i + 1;
        if(len > maxLen) {
          maxLen = len;
          ans = s.substring(mid-i, len);
        }
      }
    }

    for (int mid=0; mid<N-1; mid++) {
      for (int i=1; mid-i+1 >=0 && mid+i<N; i++) {
        if(s.charAt(mid-i+1) != s.charAt(mid+i)) {
          break;
        }
        int len = 2*i;
        if(len > maxLen) {
          maxLen = len;
          ans = s.substring(mid-i+1, len);
        }
      }
    }

    return ans;

  }

  public static void main(String[] args) {
    System.out.println(longestPalindromicSubstring("cbbd"));
  }
}
