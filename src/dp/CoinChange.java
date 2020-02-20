package dp;

/**
 * Given some amount and a set of coin change S = {S1, S2, ..., Sn} find the number of ways you can
 * convert the amount using the coins
 */
public class CoinChange {

  /**
   * method to count the number of ways
   * @param S set of coin values
   * @param m number of coins
   * @param N the total amount
   * @return
   */
  public static int count(int[] S, int m, int N) {

    // if N is 0 include no coins, so 1 solution
    if(N == 0) return 1;

    if (N < 0) return 0;

    if(m <=0 && N >= 1) return 0;

    return count(S, m-1, N) + count(S, m, N - S[m-1]);
  }

  public static void main(String[] args) {
    int[] S = {1, 2, 3};
    int N = 4;
    System.out.println(count(S,3, N));
  }
}
