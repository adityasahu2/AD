//Write a Java program to implement coin exchange 
/*
algorithm
count(coins, n, sum)
  CREATE 2D ARRAY dp OF SIZE (n+1) x (sum+1) INITIALIZED TO 0
  dp[0][0] = 1  
  FOR i FROM 1 TO n
      FOR j FROM 0 TO sum
          dp[i][j] += dp[i-1][j]  
          IF j >= coins[i-1] THEN
              dp[i][j] += dp[i][j - coins[i-1]]  
  RETURN dp[n][sum]
*/
import java.util.*;
public class CE {
  static int count(List<Integer> coins, int n, int sum) {
    int[][] dp = new int[n + 1][sum + 1];
    dp[0][0] = 1;
    for (int i = 1; i <= n; i++) 
      for (int j = 0; j <= sum; j++) {
        dp[i][j] += dp[i - 1][j];
        if ((j - coins.get(i - 1)) >= 0) 
          dp[i][j] += dp[i][j - coins.get(i - 1)];
      }
    return dp[n][sum];
  }
  public static void main(String[] args) {
    List<Integer> coins = Arrays.asList(1, 2, 3);
    int n = coins.size();
    int sum = 5;
    System.out.println(count(coins, n, sum));
  }
}
//output 5

// public class Q1{
//   public static void main(String [] args){
//     int[] coins = {1,2,5,10,20,50,100,200};
//     int amount = 231;
//     int[] result = coinExchange(coins,amount);
//     for(int i=0;i<result.length;i++) System.out.println(coins[i] + " : " + result[i]);
//   }
//   public static int[] coinExchange(int[] coins, int amount){
//     int[] coinCount = new int[coins.length];
//     for(int i=coins.length-1;i>=0;i--){
//       coinCount[i] = amount/coins[i];
//       amount = amount%coins[i];
//     }
//     return coinCount;
//   }
// }