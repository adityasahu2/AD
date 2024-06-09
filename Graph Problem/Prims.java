// 1) Write a java program to implement prims algo to find min spanning tree
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
class Graph {
    int count;
    private final LinkedList<LinkedList<Edge>> Adj;
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
    public void prims() {
        int[] previous = new int[count];
        int[] dist = new int[count];
        boolean[] visited = new boolean[count];

        Arrays.fill(previous, -1);
        Arrays.fill(dist, Integer.MAX_VALUE);// infinite

        int source = 0;
        dist[source] = 0;
        previous[source] = source;

        PriorityQueue<Edge> queue = new PriorityQueue<Edge>(100);
        Edge node = new Edge(source, source, 0);
        queue.add(node);

        while (!queue.isEmpty()) {
            node = queue.peek();
            queue.remove();
            visited[source] = true;
            source = node.dest;
            LinkedList<Edge> adl = Adj.get(source);
            for (Edge adn : adl) {
                int dest = adn.dest;
                int alt = adn.cost;
                if (dist[dest] > alt && !visited[dest]) {
                    dist[dest] = alt;
                    previous[dest] = source;
                    node = new Edge(source, dest, alt);
                    queue.add(node);
                }
            }
        }
        // printing result.
        int sum = 0;
        boolean isMst = true;
        String output = "Edges @ Weight";
        for (int i = 0; i < count; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                output += ("\n" + i + ", Unreachable");
                isMst = false;
                break;
            } else if (previous[i] != i) {
                output += ("\n" + previous[i] + "->" + i + " @ " + dist[i] );
                sum += dist[i];
            }
        }
        if (isMst) {
            System.out.println(output);
            System.out.println("Total MST cost : " + sum);
        } else System.out.println("Can't get a Spanning Tree");
    }
}
// Testing code
public class Prims {
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
        gph.prims();
    }
}
// Output
/*
Edges are :
(0->1 @ 4)
(5->2 @ 4)
(2->3 @ 7)
(3->4 @ 9)
(6->5 @ 2)
(7->6 @ 1)
(0->7 @ 8)
(2->8 @ 2)
Total MST cost : 37
*/