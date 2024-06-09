// write a java program to implement robin karp algorithm for pattern searching in a string.
public class RobinKarp {
    public static int robinKarp(String textIn, String patternIn) {
        char[] text = textIn.toCharArray(), pattern = patternIn.toCharArray();
        int n = text.length , m = pattern.length ,prime = 101 , powm = 1 ,TextHash = 0, PatternHash = 0 ;
        if (m == 0 || m > n) return -1;
        for (int i = 0; i < m - 1; i++) powm = (powm << 1) % prime;
        for (int i = 0; i < m; i++) {
            PatternHash = ((PatternHash << 1) + pattern[i]) % prime;
            TextHash = ((TextHash << 1) + text[i]) % prime;
        }
        for (int i = 0; i <= (n - m); i++) {
            if (TextHash == PatternHash) {
                for (int j = 0; j < m; j++) if (text[i + j] != pattern[j]) break;
                if (j == m) return i;
            }
            if (i < n - m) TextHash = (((TextHash - text[i] * powm) << 1) + text[i + m]) % prime;
            if (TextHash < 0) TextHash = (TextHash + prime);
        } return -1;
    }
    public static void main(String[] args) {
        String st1 = "hello, world!";
        String st2 = "world";
        System.out.println("RobinKarp return : " + robinKarp(st1, st2));
    }
}