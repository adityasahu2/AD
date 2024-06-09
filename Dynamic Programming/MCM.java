//Write a Java program to implement matrix chain multiplications
/*
algorithm
MatrixChainOrder(p[], n):
  m[][] = new int[n][n]
  for i from 1 to n:
      m[i][i] = 0
  for L from 2 to n-1:
      for i from 1 to n-L+1:
          j = i + L - 1
          if j == n:
              continue
          m[i][j] = INFINITY
          for k from i to j-1:
              q = m[i][k] + m[k+1][j] + p[i-1] * p[k] * p[j]
              if q < m[i][j]:
                  m[i][j] = q
  return m[1][n-1]
*/
public class MCM {
  public static int MatrixChainOrder(int p[], int n){
    int m[][] = new int[n][n];
    int i, j, k, L, q;
    for (i = 1; i < n; i++) m[i][i] = 0;
    for (L = 2; L < n; L++) 
      for (i = 1; i < n - L + 1; i++) {
        j = i + L - 1;
        if (j == n) continue;
        m[i][j] = Integer.MAX_VALUE;
        for (k = i; k <= j - 1; k++) {
          q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
          if (q < m[i][j]) m[i][j] = q;
        }
      }
    return m[1][n - 1];
  }
  public static void main(String args[]){
    int arr[] = new int[] { 1, 2, 3, 4 };
    int size = arr.length;
    System.out.println("Minimum number of multiplications is " + MatrixChainOrder(arr, size));
  }
}
/*
output
Maximum number of multiplicaton is 18
*/

// public class Q2{
//   public static void main(String [] args){
//     int[] p = {10,20,50,100,200};
//     int[][] m = new int[p.length][p.length];
//     int[][] s = new int[p.length][p.length];
//     for(int i=0;i<p.length;i++){
//       for(int j=0;j<p.length;j++){
//         m[i][j] = -1;
//         s[i][j] = -1;
//       }
//     }
//     System.out.println(matrixChain(p,m,s,0,p.length-1));
//   }
//   public static int matrixChain(int[] p, int[][] m, int[][] s, int i, int j){
//     if(i==j) return 0;
//     if(m[i][j]!=-1) return m[i][j];
//     int min = Integer.MAX_VALUE;
//     for(int k=i;k<j;k++){
//       int q = matrixChain(p,m,s,i,k) + matrixChain(p,m,s,k+1,j) + p[i-1]*p[k]*p[j];
//       if(q<min){
//         min = q;
//         s[i][j] = k;
//       }
//     }
//     m[i][j] = min;
//     return min;
//   }
// }