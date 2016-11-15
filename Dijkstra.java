import java.util.ArrayList;

/**
 * Created by Julio oon 11/15/2016.
 */
public class Dijkstra {
    Grafo newGrafo = new Grafo();
    private ArrayList<String> connectedNodesArrayName  =  new ArrayList <>();

    Node start = new Node();

    public void sdjas () {
        for (int i = 0; i < 11; i++) {
            System.out.println("Count is: " + i);
        }
    }

    /**
     *  base para algortimo
     1  function Dijkstra(Graph, source):
     2
     3      create vertex set Q
     4
     5      for each vertex v in Graph:             // Initialization
     6          dist[v] ← INFINITY                  // Unknown distance from source to v
     7          prev[v] ← UNDEFINED                 // Previous node in optimal path from source
     8          add v to Q                          // All nodes initially in Q (unvisited nodes)
     9
     10      dist[source] ← 0                        // Distance from source to source
     11
     12      while Q is not empty:
     13          u ← vertex in Q with min dist[u]    // Source node will be selected first
     14          remove u from Q
     15
     16          for each neighbor v of u:           // where v is still in Q.
     17              alt ← dist[u] + length(u, v)
     18              if alt < dist[v]:               // A shorter path to v has been found
     19                  dist[v] ← alt
     20                  prev[v] ← u
     21
     22      return dist[], prev[]
     */
}
