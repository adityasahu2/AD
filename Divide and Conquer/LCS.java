//Longest Common Subsequence
// A Naive recursive implementation of LCS problem in java
/*
Alogorithm
LCSubStr(st1, st2)
    X = CONVERT st1 TO CHAR ARRAY
    Y = CONVERT st2 TO CHAR ARRAY
    m = LENGTH OF st1
    n = LENGTH OF st2
    CREATE 2D ARRAY dp[m+1][n+1] INITIALIZED TO 0
    CREATE 2D ARRAY p[m+1][n+1] INITIALIZED TO 0

    FOR i FROM 1 TO m
        FOR j FROM 1 TO n
            IF X[i-1] == Y[j-1] THEN
                dp[i][j] = dp[i-1][j-1] + 1
                p[i][j] = 0
            ELSE
                IF dp[i-1][j] > dp[i][j-1] THEN
                    dp[i][j] = dp[i-1][j]
                    p[i][j] = 1
                ELSE
                    dp[i][j] = dp[i][j-1]
                    p[i][j] = 2

    PRINT "The LCS is : "
    CALL PrintLCS(p, X, m, n)
    RETURN dp[m][n]

PrintLCS(p, X, i, j)
    IF i == 0 OR j == 0 THEN
        RETURN
    IF p[i][j] == 0 THEN
        CALL PrintLCS(p, X, i-1, j-1)
        PRINT X[i-1]
    ELSE IF p[i][j] == 1 THEN
        CALL PrintLCS(p, X, i-1, j)
    ELSE
        CALL PrintLCS(p, X, i, j-1)
*/

public class LCS {
    static int LCSubStr(String st1, String st2) {
        char X[] = st1.toCharArray();
        char Y[] = st2.toCharArray();
        int m = st1.length();
        int n = st2.length();
        int dp[][] = new int[m + 1][n + 1];
        int p[][] = new int[m + 1][n + 1]; 
        for (int i = 1; i <= m; i++) 
            for (int j = 1; j <= n; j++) 
                if (X[i - 1] == Y[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    p[i][j] = 0;
                } else {
                    dp[i][j] = (dp[i - 1][j] > dp[i][j - 1]) ? dp[i - 1][j] : dp[i][j - 1];
                    p[i][j] = (dp[i - 1][j] > dp[i][j - 1]) ? 1 : 2;
                }
        System.out.print("LCS is : ");
        PrintLCS(p, X, m, n);
        return dp[m][n];
    }
    static void PrintLCS(int[][] p, char[] X, int i, int j) {
        if (i == 0 || j == 0) return;
        if (p[i][j] == 0) {
            PrintLCS(p, X, i - 1, j - 1);
            System.out.print(X[i - 1]);
        } 
        else if (p[i][j] == 1) PrintLCS(p, X, i - 1, j);
        else PrintLCS(p, X, i, j - 1);
    }
    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        System.out.println("\nLength of LCS is : "+LCSubStr(X, Y));
    }
}
/*
output
LCS is : GTAB
Length of LCS is : 4
*/
