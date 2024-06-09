// 3) Write a java program to implement dijkstra algo to find min spanning tree
import java.util.*;
class Edge implements Comparable<Edge> {
    int src, dest, cost;
    public Edge(int s, int d, int c) {
        src = s;
        dest = d;
        cost = c;
    } public int compareTo(Edge compareEdge) {
        return this.cost - compareEdge.cost;
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
    String printPathUtil(int[] previous, int source, int dest) {
        String path = "";
        if (dest == source) path += source;
        else {
            path += printPathUtil(previous, source, previous[dest]);
            path += ("->" + dest);
        } return path;
    }
    public void printPath(int[] previous, int[] dist, int count, int source) {
        String output = "Shortest Paths @ Path Weight ";
        for (int i = 0; i < count; i++) {
            if (dist[i] == 99999) output += ("\n" + source + "->" + i + " @ Unreachable ");
            else if (i != previous[i]) {
                output += "\n";
                output += printPathUtil(previous, source, i);
                output += (" @ " + dist[i]);
            }
        } System.out.println(output);
    }
    public void dijkstra(int source) {
        int[] previous = new int[count];
        int[] dist = new int[count];
        boolean[] visited = new boolean[count];

        Arrays.fill(previous, -1);
        Arrays.fill(dist, 99999); // infinite

        dist[source] = 0;
        previous[source] = source;

        PriorityQueue<Edge> queue = new PriorityQueue<Edge>(100);
        Edge edge = new Edge(source, source, 0);
        queue.add(edge);
        int curr;

        while (!queue.isEmpty()) {
            edge = queue.peek();
            queue.remove();
            curr = edge.dest;
            visited[curr] = true;
            LinkedList<Edge> adl = Adj.get(curr);

            for (Edge adn : adl) {
                int dest = adn.dest;
                int alt = adn.cost + dist[curr];

                if (alt < dist[dest] && !visited[dest]) {
                    dist[dest] = alt;
                    previous[dest] = curr;
                    edge = new Edge(curr, dest, alt);
                    queue.add(edge);
                }
            }
        } printPath(previous, dist, count, source);
    }
}

// Testing code
public class Dijkstra {
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
        gph.dijkstra(0);
    }
}
// Output
/*
Shortest Paths: 
(0->1 @ 4) 
(0->1->2 @ 12) 
(0->1->2->3 @ 19) 
(0->7->6->5->4 @ 21) 
(0->7->6->5 @ 11) 
(0->7->6 @ 9) 
(0->7 @ 8) 
(0->1->2->8 @ 14) 
*/