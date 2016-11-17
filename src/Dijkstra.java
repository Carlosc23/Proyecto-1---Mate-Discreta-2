import java.util.ArrayList;
import java.util.*;

/**
 * Por:     Julio Barahona
 * carne:   141206
 * UVG
 */

public class Dijkstra {

    private Grapho graph;
    private String initialVerticeLabel;
    private HashMap<String, String> predecessors;
    private HashMap<String, Integer> distances;
    private PriorityQueue<Vertice> availableVertices;
    private HashSet<Vertice> visitedVertices;


    /**
     * @param graph The Graph to traverse
     * @param initialVerticeLabel The starting Vertice label
     * @throws IllegalArgumentException If the specified initial vertex is not in the Graph
     */
    public Dijkstra(Grapho graph, String initialVerticeLabel){
        this.graph = graph;
        Set<String> vertexKeys = this.graph.vertexKeys();

        if(!vertexKeys.contains(initialVerticeLabel)){
            throw new IllegalArgumentException("The graph must contain the initial vertex.");
        }

        this.initialVerticeLabel = initialVerticeLabel;
        this.predecessors = new HashMap<String, String>();
        this.distances = new HashMap<String, Integer>();
        this.availableVertices = new PriorityQueue<Vertice>(vertexKeys.size(), new Comparator<Vertice>(){

            public int compare(Vertice one, Vertice two){
                int weightOne = Dijkstra.this.distances.get(one.getNombre());
                int weightTwo = Dijkstra.this.distances.get(two.getNombre());
                return weightOne - weightTwo;
            }
        });

        this.visitedVertices = new HashSet<Vertice>();

        //for each Vertice in the graph
        //assume it has distance infinity denoted by Integer.MAX_VALUE
        for(String key: vertexKeys){
            this.predecessors.put(key, null);
            this.distances.put(key, Integer.MAX_VALUE);
        }


        //the distance from the initial vertex to itself is 0
        this.distances.put(initialVerticeLabel, 0);

        //and seed initialVertice's conexions
        Vertice initialVertice = this.graph.getVertex(initialVerticeLabel);
        ArrayList<Arista> initialVerticeConexions = initialVertice.getConexiones();
        for(Arista e : initialVerticeConexions){
            Vertice other = e.getConexion(initialVertice);
            this.predecessors.put(other.getNombre(), initialVerticeLabel);
            this.distances.put(other.getNombre(), e.getWeight());
            this.availableVertices.add(other);
        }

        this.visitedVertices.add(initialVertice);

        //now apply Dijkstra's algorithm to the GRapho
        processGrapho();

    }

    /**
     * This method applies Dijkstra's algorithm to the graph using the Vertice
     * specified by initialVerticeLabel as the starting point.
     *
     * @post The shortest a-b paths as specified by Dijkstra's algorithm and
     *       their distances are available
     */
    private void processGrapho(){

        //as long as there are Aristas to process
        while(this.availableVertices.size() > 0){

            //pick the cheapest vertex
            Vertice next = this.availableVertices.poll();
            int distanceToNext = this.distances.get(next.getNombre());

            //and for each available conexion of the chosen vertex
            List<Arista> nextConexions = next.getConexiones();
            for(Arista e: nextConexions){
                Vertice other = e.getConexion(next);
                if(this.visitedVertices.contains(other)){
                    continue;
                }

                //we check if a shorter path exists
                //and update to indicate a new shortest found path
                //in the graph
                int currentWeight = this.distances.get(other.getNombre());
                int newWeight = distanceToNext + e.getWeight();

                if(newWeight < currentWeight){
                    this.predecessors.put(other.getNombre(), next.getNombre());
                    this.distances.put(other.getNombre(), newWeight);
                    this.availableVertices.remove(other);
                    this.availableVertices.add(other);
                }

            }

            // finally, mark the selected vertex as visited
            // so we don't revisit it
            this.visitedVertices.add(next);
        }
    }


    /**
     *
     * @param destinationLabel The Vertice whose shortest path from the initial Vertice is desired
     * @return LinkedList<Vertice> A sequence of Vertice objects starting at the
     *         initial Vertice and terminating at the Vertice specified by destinationLabel.
     *         The path is the shortest path specified by Dijkstra's algorithm.
     */
    public List<Vertice> getPathTo(String destinationLabel){
        LinkedList<Vertice> path = new LinkedList<Vertice>();
        path.add(graph.getVertex(destinationLabel));

        while(!destinationLabel.equals(this.initialVerticeLabel)){
            Vertice predecessor = graph.getVertex(this.predecessors.get(destinationLabel));
            destinationLabel = predecessor.getNombre();
            path.add(0, predecessor);
        }
        return path;
    }


    /**
     *
     * @param destinationLabel The Vertice to determine the distance from the initial Vertice
     * @return int The distance from the initial Vertice to the Vertice specified by destinationLabel
     */
    public int getDistanceTo(String destinationLabel){
        return this.distances.get(destinationLabel);
    }


    public static void main(String[] args){
        Grapho graph = new Grapho();
        Vertice[] vertices = new Vertice[6];

        for(int i = 0; i < vertices.length; i++){
            vertices[i] = new Vertice(i + "");
            graph.addVertice(vertices[i], true);
        }

        Arista[] conexiones = new Arista[9];
        conexiones[0] = new Arista(vertices[0], vertices[1], 7);
        conexiones[1] = new Arista(vertices[0], vertices[2], 9);
        conexiones[2] = new Arista(vertices[0], vertices[5], 14);
        conexiones[3] = new Arista(vertices[1], vertices[2], 10);
        conexiones[4] = new Arista(vertices[1], vertices[3], 15);
        conexiones[5] = new Arista(vertices[2], vertices[3], 11);
        conexiones[6] = new Arista(vertices[2], vertices[5], 2);
        conexiones[7] = new Arista(vertices[3], vertices[4], 6);
        conexiones[8] = new Arista(vertices[4], vertices[5], 9);

        for(Arista e: conexiones){
            graph.addArista(e.getOne(), e.getTwo(), e.getWeight());

        }

        Dijkstra dijkstra = new Dijkstra(graph, vertices[0].getNombre());
        System.out.println(dijkstra.getDistanceTo("5"));
        System.out.println(dijkstra.getPathTo("5"));
    }
}

    /**
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
     16          for each conexion v of u:           // where v is still in Q.
     17              alt ← dist[u] + length(u, v)
     18              if alt < dist[v]:               // A shorter path to v has been found
     19                  dist[v] ← alt
     20                  prev[v] ← u
     21
     22      return dist[], prev[]
     */