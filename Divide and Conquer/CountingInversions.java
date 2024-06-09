//write a java program to count the no. of inversions in an array using merge sort. Display the pairs of inversions and the number of inversions.

/*
function mergeAndCount(arr, l, m, r):
    // Copy the subarrays from arr
    left = copy of arr from index l to m
    right = copy of arr from index m+1 to r
    i = 0
    j = 0
    k = l
    swaps = 0

    // Merge left and right subarrays
    while (i < length of left and j < length of right):
        if (left[i] <= right[j]):
            arr[k] = left[i]
            k++
            i++
        else:
            // Increment swaps count and print pairs of inversions
            for n from i to length of left - 1:
                print "(" + left[n] + "," + right[j] + ") "
            arr[k] = right[j]
            k++
            j++
            swaps += (m + 1) - (l + i)

    // Copy remaining elements of left and right subarrays
    while (i < length of left):
        arr[k] = left[i]
        k++
        i++
    while (j < length of right):
        arr[k] = right[j]
        k++
        j++

    return swaps

function mergeSortAndCount(arr, l, r):
    count = 0
    if (l < r):
        m = (l + r) / 2
        // Recursively sort and count inversions in left and right halves
        count += mergeSortAndCount(arr, l, m)
        count += mergeSortAndCount(arr, m + 1, r)
        // Merge left and right halves and count inversions
        count += mergeAndCount(arr, l, m, r)
    return count

// Main function
arr = [6, 3, 9, 5, 2, 8, 7, 1]
print "Array:", arr
print "Inversions:"
inversions_count = mergeSortAndCount(arr, 0, length of arr - 1)
print "Number of inversions:", inversions_count
*/

import java.util.Arrays;
public class CountingInversions {
  private static int mergeAndCount(int[] arr, int l, int m, int r) {
    int[] left = Arrays.copyOfRange(arr, l, m + 1);
    int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);
    int i = 0, j = 0, k = l, swaps = 0;
    while (i < left.length && j < right.length) {
      if (left[i] <= right[j]) arr[k++] = left[i++];
      else {
        for(int n = i;n < left.length;n++) System.out.print("(" + left[n] + "," + right[j] + ") ");
        arr[k++] = right[j++];
        swaps += (m + 1) - (l + i);
      }
    }
    while (i < left.length) arr[k++] = left[i++];
    while (j < right.length) arr[k++] = right[j++];
    return swaps;
  } 
  private static int mergeSortAndCount(int[] arr, int l, int r) {
    int count = 0;
    if (l < r) {
      int m = (l + r) / 2;
      count += mergeSortAndCount(arr, l, m);
      count += mergeSortAndCount(arr, m + 1, r);
      count += mergeAndCount(arr, l, m, r);
    } return count;
  } 
  public static void main(String[] args) {
    int[] arr = { 6, 3, 9, 5, 2, 8, 7, 1 };
    System.out.println("Array : "+Arrays.toString(arr));
    System.out.print("Inversions : ");
    System.out.println("\nNumber of invversions : "+mergeSortAndCount(arr, 0, arr.length - 1));
  }
}

/*
Array : [6, 3, 9, 5, 2, 8, 7, 1] 
Inversions': (6,3) (9,5) (6,5) (7,1) (2,1) (8,1) (8,7) (3,1) (5,1) (6,1) (9,1) (3,2) (5,2) (6,2) (9,2) (9,7) (9,8)
Number of invversions: 17
*/