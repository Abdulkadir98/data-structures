package dp;


/**
 * Given an associative expression of Matrices, find a way to parenthesize the matrices to reduce
 * the overall cost of multiplication
 * Recurrence: DP(i,j) = min {Dp(i, k) + Dp(k, j) + cost of Product(A[i,k] * A[k,j]}
 */
public class ParenthesizationMatrixChainMultiplication {


  static int parenthesize(int[] p, int i, int j) {

    if (i == j) return 0;

    int min = Integer.MAX_VALUE;

    for (int k = i; k<j; k++) {
      int count = parenthesize(p, i, k) + parenthesize(p, k+1, j) + p[i-1]*p[k]*p[j];
      if(count < min) {
        min = count;
      }
    }



    return min;

  }

  // tabular form of Matrix Order
  static int bottomUpMatrixOrder(int[] p, int[][] s) {
    int N = p.length;


    int[][] M = new int[N][N];

    for (int l=2; l<N; l++) {  // l is length of chain
      for (int i=1; i<N-l+1; i++) {
        int j = i+l-1;

        M[i][j] = Integer.MAX_VALUE;

        for (int k=i; k<j; k++) {
          int min = M[i][k] + M[k+1][j] + p[i-1]*p[k]*p[j];

          if(min < M[i][j]) {
            M[i][j] = min;
            s[i][j] = k;
          }
        }
      }
    }

    return M[1][N-1];
  }

  static String printOptimalParens(int[][] s, int i, int j) {
    if(i == j) {
      return "A"+i;
    }
    else {
      return "(" + printOptimalParens(s, i, s[i][j]) + printOptimalParens(s, s[i][j]+1, j) + ")";
    }
  }

  public static void main(String[] args) {
    int[] p = {30, 35, 15, 5, 10, 20, 25};
    int[][] s = new int[p.length-1][p.length];
    //System.out.println(parenthesize(p, 1, p.length-1));
    System.out.println(bottomUpMatrixOrder(p, s));
    System.out.println(printOptimalParens(s, 1, p.length-1));
  }
}
