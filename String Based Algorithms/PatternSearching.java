// Write a java program to brute force algorithm for pattern searching in a string.
public class PatternSearching{
	public static int bruteForceSearch(String textIn, String patternIn) {
		char[] text = textIn.toCharArray();
		char[] pattern = patternIn.toCharArray();
    final int n = text.length , m = pattern.length;
    for (int i = 0; i<= n-m; i++){
        int j = 0;
        for ( ; j<m && pattern[j] == text[i+j] ; j++);
        if (j == m) return (i); 
    } return -1;
	}
	public static void main(String[] args) {
		String st1 = "hello, world!";
		String st2 = "world";
		System.out.println("BruteForceSearch return : " + bruteForceSearch(st1, st2));
	}
}
/*
// Algorithm
Algorithm BruteForceStringMatch (T[0..n - 1], P[0..m - 1])
	for i = 0 to n - m do
	j = 0
	while j < m and P[j] = T[i + j] do
	j = j + 1
	if j = m then
	return i
	return -1
*/