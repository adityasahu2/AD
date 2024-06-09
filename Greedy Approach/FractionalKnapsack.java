//Write a program to implement fractional knapsack algorithm.
/*
  Algorithm	FractionalKnapsack(W[],	C[], Wk)
  For	i	=	1	to n do
  X[i] = 0
  Weight = 0
  //Use	Max	heap
  H	=	BuildMaxHeap(C/W)
  While	Weight < Wk do
  i	=	H.GetMax()
  If(Weight	+	W[i] <= Wk)	do
  X[i] = 1
  Weight = Weight + W[i]
  Else
  X[i] = (Wk – Weight)/W[i]
  Weight = Wk
  Return X
*/
import java.util.Arrays;
class Items implements Comparable<Items> {
    int wt, cost;
    double density;
    Items(int w, int v) {
        wt = w;
        cost = v;
        density = (double) cost / wt;
    }
    public int compareTo(Items s2) {return (int) (s2.density - this.density);}
}
public class FractionalKnapsack {
    public double getMaxCostFractional(int[] wt, int[] cost, int capacity) {
        double totalCost = 0;
        int n = wt.length;
        Items[] itemList = new Items[n];
        for (int i = 0; i < n; i++) itemList[i] = new Items(wt[i], cost[i]);
        Arrays.sort(itemList);
        for (int i = 0; i < n; i++) {
            if (capacity - itemList[i].wt >= 0) {
                capacity -= itemList[i].wt;
                totalCost += itemList[i].cost;
            } else {
                totalCost += (itemList[i].density * capacity);
                break;
            }
        } return totalCost;
    }
    public static void main(String[] args) {
        int[] wt = { 10, 40, 20, 30 };
        int[] cost = { 60, 40, 90, 120 };
        int capacity = 50;
        FractionalKnapsack kp = new FractionalKnapsack();
        double maxCost = kp.getMaxCostFractional(wt, cost, capacity);
        System.out.println("Maximum cost obtained = " + maxCost);
    }
}
/*
Maximum cost obtained = 230.0
*/