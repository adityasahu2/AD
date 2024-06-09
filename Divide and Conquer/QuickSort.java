/*
//	Sorts	a	subarray	by	quicksort
 //	Input:	An	subarray	of	A
 //	Output:	List	A[l..r]	in	ascending	order

Algorithm	Quicksort(A[l..r])
   if	l	<	r	then
   p	←	Partition(A[l..r])	//	p	is	index	of	pivot
   Quicksort(A[l..p	−	1])
   Quicksort(A[p	+	1..r])

//	Partitions	a	subarray	using	A[..]	as	pivot
 //	Input:	Subarray	of	A
 //	Output:	Final	position	of	pivot

Algorithm	Partition(A[],	left,	right)
   pivot	=	A[left]
   lower	=	left
   upper=	right
   while	lower	<	upper
     while	A[lower]	<=	pivot
        lower	=	lower	+	1
     while	A[upper]	>	pivot
        upper	=	upper	–	1
     if	lower	<	upper	then
        swap	A[lower]	and	A[upper]
   swap	A[lower]	and	A[upper]	//upper	is	the	pivot	position
   return	upper
*/
public class QuickSort {
  private void quickSort(int arr[], int lower, int upper) {
    if (upper <= lower) return;
    int pivot = arr[lower];
    int start = lower;
    int stop = upper;
    while (lower < upper) { 
      while (arr[lower] <= pivot && lower < upper) lower++;
      while (arr[upper] > pivot && lower <= upper) upper--;
      if (lower < upper) swap(arr, upper, lower);
    }
    swap(arr, upper, start); // upper is the pivot position
    quickSort(arr, start, upper - 1); // pivot -1 is the upper for left sub array.
    quickSort(arr, upper + 1, stop); // pivot + 1 is the lower for right sub array
  }
  public void sort(int[] arr) {
    int size = arr.length;
    quickSort(arr, 0, size - 1);
  }
  private void swap(int arr[], int first, int second) {
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
  }
  public static void main(String[] args) {
    int[] array = { 3, 4, 2, 1, 6, 5, 7, 8, 10, 9 };
    QuickSort srt = new QuickSort();
    srt.sort(array);
    for (int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
  }
}
// 1 2 3 4 5 6 7 8 9 10