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

    public void addUndirectedEdge(int source, int dest) {
        addUndirectedEdge(source, dest, 1);
    }

    public static void printAllPathDFS(Graph gph, boolean[] visited, int source, int dest, Stack<Integer> path) {
        path.push(source);
        if (source == dest) {
            if(path.size() == dest+1)
                System.out.println(path);
            path.pop();
            return;
        }
        visited[source] = true;
        LinkedList<Edge> adl = gph.Adj.get(source);
        for (Edge adn : adl) {
            if (visited[adn.dest] == false) {
                printAllPathDFS(gph, visited, adn.dest, dest, path);

            }
        }
        visited[source] = false;
    }
}
public class DFS{
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
        boolean [] visited = new boolean[8];
        Stack<Integer> path = new Stack<>();
        System.out.print("DFS Traversal :");
        gph.printAllPathDFS(gph,visited,0,7,path);
    }
}