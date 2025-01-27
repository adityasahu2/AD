// 2) Write a java program to implement kruskal algo to find min spanning tree
import java.util.*;
class Edge implements Comparable<Edge> {
    int src, dest, cost;
    public Edge(int s, int d, int c) {
        src = s;
        dest = d;
        cost = c;
    }
    public int compareTo(Edge compareEdge) {
        return this.cost - compareEdge.cost;
    }
}
class Sets {
    int parent;
    int rank;
    Sets(int p, int r) {
        parent = p;
        rank = r;
    }
}
class Graph {
    int count;
    private LinkedList<LinkedList<Edge>> Adj;
    public Graph(int cnt) {
        count = cnt;
        Adj = new LinkedList<>();
        for (int i = 0; i < cnt; i++) Adj.add(new LinkedList<>());
    }
    private void addDirectedEdge(int source, int dest, int cost) {
        Edge edge = new Edge(source, dest, cost);
        Adj.get(source).add(edge);
    }
    public void addUndirectedEdge(int source, int dest, int cost) {
        addDirectedEdge(source, dest, cost);
        addDirectedEdge(dest, source, cost);
    }
    // root element of set
    public int find(Sets[] sets, int index) {
        int p = sets[index].parent;
        while (p != index) {
            index = p;
            p = sets[index].parent;
        } return index;
    }
    // consider x and y are roots of sets.
    public void union(Sets[] sets, int x, int y) {
        if (sets[x].rank < sets[y].rank) sets[x].parent = y;
        else if (sets[y].rank < sets[x].rank) sets[y].parent = x;
        else {
            sets[x].parent = y;
            sets[y].rank++;
        }
    }
    public void kruskal() {
        // Different subsets are created.
        Sets[] sets = new Sets[count];
        for (int i = 0; i < count; i++) sets[i] = new Sets(i, 0);

        // Edges are added to array and sorted.
        int E = 0;
        Edge edge[] = new Edge[100];
        for (int i = 0; i < count; i++) {
            LinkedList<Edge> ad = Adj.get(i);
            for (Edge adn : ad) edge[E++] = adn;
        }
        Arrays.sort(edge, 0, E - 1);

        int sum = 0;
        String output = "Edges @ Weight";
        for (int i = 0; i < E; i++) {
            int x = find(sets, edge[i].src);
            int y = find(sets, edge[i].dest);
            if (x != y) {
                output += ("\n" + edge[i].src + "->" + edge[i].dest + " @ " + edge[i].cost);
                sum += edge[i].cost;
                union(sets, x, y);
            }
        }
        System.out.println(output);
        System.out.println("Total MST cost : " + sum);
    }
}
// Testing code
public class Kruskal {
    public static void main(String[] args) {
        Graph gph = new Graph(9);
        gph.addUndirectedEdge(0, 1, 4);
        gph.addUndirectedEdge(0, 7, 8);
        gph.addUndirectedEdge(1, 2, 8);
        gph.addUndirectedEdge(1, 7, 11);
        gph.addUndirectedEdge(2, 3, 7);
        gph.addUndirectedEdge(2, 8, 2);
        gph.addUndirectedEdge(2, 5, 4);
        gph.addUndirectedEdge(3, 4, 9);
        gph.addUndirectedEdge(3, 5, 14);
        gph.addUndirectedEdge(4, 5, 10);
        gph.addUndirectedEdge(5, 6, 2);
        gph.addUndirectedEdge(6, 7, 1);
        gph.addUndirectedEdge(6, 8, 6);
        gph.addUndirectedEdge(7, 8, 7);
        gph.kruskal();
    }
}
// Output
/*
Edges are : 
(6->7 @ 1) 
(2->8 @ 2) 
(5->6 @ 2) 
(0->1 @ 4) 
(2->5 @ 4) 
(2->3 @ 7) 
(0->7 @ 8) 
(3->4 @ 9) 
Total MST cost : 37
*/