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
    public void addUndirectedEdge(int source, int dest) {addUndirectedEdge(source, dest, 1);}
    public void bfsLevelNode(int source) {
        boolean[] visited = new boolean[count];
        int[] level = new int[count];
        visited[source] = true;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        level[source] = 0;
        System.out.println("Node - Level");
        while (queue.isEmpty() == false) {
            int curr = queue.remove();
            int depth = level[curr];
            LinkedList<Edge> adl = Adj.get(curr);
            System.out.println(curr + " - " + depth);
            for (Edge adn : adl) {
                if (visited[adn.dest] == false) {
                    visited[adn.dest] = true;
                    queue.add(adn.dest);
                    level[adn.dest] = depth + 1;
                }
            }
        }
    }
}
public class BFS{
    public static void main(String[]args) {
        Graph gph = new Graph(8);
        gph.addUndirectedEdge(0, 3);
        gph.addUndirectedEdge(0, 2);
        gph.addUndirectedEdge(0, 1);
        gph.addUndirectedEdge(1, 4);
        gph.addUndirectedEdge(2, 5);
        gph.addUndirectedEdge(3, 6);
        gph.addUndirectedEdge(6, 7);
        gph.addUndirectedEdge(5, 7);
        gph.addUndirectedEdge(4, 7);
        gph.bfsLevelNode(0);
    }
}