/*
//	Sorts	a	given	list	by	mergesort
 //	Input:	An	array	A	of	orderable	elements
 //	Output:	List	A[0..n	−	1]	in	ascending	order

Algorithm	Mergesort(A[0..n	−	1])
   if	n	≤	1	then return;
   copy	A[0..⌊n/2⌋	−	1]	to	B[0..⌊n/2⌋	−	1]
   copy	A[⌊n/2⌋..n	−	1]	to	C[0..⌈n/2⌉	−	1]
   Mergesort(B)
   Mergesort(C)
   Merge(B,	C,	A)

//	Merges	two	sorted	arrays	into	one	list
 //	Input:	Sorted	arrays	B	and	C
 //	Output:	Sorted	list	A

Algorithm	Merge(B[0..p	−	1],	C[0..q	−	1],	A[0..p	+	q	−	1])
   i	=	0
   j	=	0
   for	k	=	0	to	p	+	q	−	1	do
      if	i	<	p	and	(j	=	q	or	B[i]	≤	C[j])	then
          A[k]	=	B[i]
          i	=	i	+	1
      else
          A[k]	=	C[j]
          j	=	j	+	1
*/
public class MergeSort {
  private void merge(int[] arr, int[] tempArray, int lowerIndex, int middleIndex, int upperIndex) {
    int lowerStart = lowerIndex;
    int lowerStop = middleIndex;
    int upperStart = middleIndex + 1;
    int upperStop = upperIndex;
    int count = lowerIndex;
    while (lowerStart <= lowerStop && upperStart <= upperStop) {
      if (arr[lowerStart] < arr[upperStart]) tempArray[count++] = arr[lowerStart++];
      else tempArray[count++] = arr[upperStart++];
    }
    while (lowerStart <= lowerStop) tempArray[count++] = arr[lowerStart++];
    while (upperStart <= upperStop) tempArray[count++] = arr[upperStart++];
    for (int i = lowerIndex; i <= upperIndex; i++) arr[i] = tempArray[i];
  }
  private void mergeSrt(int[] arr, int[] tempArray, int lowerIndex, int upperIndex) {
    if (lowerIndex >= upperIndex) return;
    int middleIndex = (lowerIndex + upperIndex) / 2;
    mergeSrt(arr, tempArray, lowerIndex, middleIndex);
    mergeSrt(arr, tempArray, middleIndex + 1, upperIndex);
    merge(arr, tempArray, lowerIndex, middleIndex, upperIndex);
  }
  public void sort(int[] arr) {
    int size = arr.length;
    int[] tempArray = new int[size];
    mergeSrt(arr, tempArray, 0, size - 1);
  }
  public static void main(String[] args) {
    int[] array = { 3, 4, 2, 1, 6, 5, 7, 8 };
    MergeSort m = new MergeSort();
    m.sort(array);
    for (int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
  }
}
// 1 2 3 4 5 6 7 8