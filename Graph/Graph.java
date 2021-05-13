/**
 * Graph class - creates a graph adt for which data can be stored
 * @author Dylan VanAllen
 */
import java.util.*;
public class Graph {
    //enum to differentiate between undirected and weighted graphs
    public enum graphType {UNDIRECTED, WEIGHTED}


    Map<Vertex, List<Vertex>> adjacencyList;
    List<Edge> edges;
    Graph.graphType type;

    /**
     * constructor for new empty graph of specified type
     * @param t the type of the graph to be made
     */
    public Graph(Graph.graphType t) {
        this.type = t;
        this.adjacencyList = new HashMap<Vertex, List<Vertex>>();
        this.edges = new ArrayList<Edge>();
    }
    /**
     * determines if the graph has no vertices
     * @return true if graph is empty
     */
    public boolean isEmpty() {
        if (adjacencyList.isEmpty()) return true;
        else return false;
    }
    /**
     * adds a new vertex into the graph with no edges
     * @param val the value of the vertex to add
     */
    public void insertVertex(String val) {
        Vertex v = new Vertex(val);
        adjacencyList.putIfAbsent(v, new ArrayList<>());
    }
    /**
     * removes a vertex from the graph and all edges to this vertex
     * @param val the values of the vertex to be removed
     */
    public Vertex removeVertex(String val) {
        Vertex v = new Vertex(val);
        adjacencyList.values().stream().forEach(e -> e.remove(v));
        adjacencyList.remove(new Vertex(val));
        return v;
    }
    /**
     * @return the number of vertices in the graph
     */
    public int numVertices() {
        return adjacencyList.size();
    }
    /**
     * @return the number of edges in the graph
     */
    public int numEdges() {
        return edges.size();
    }
    /**
     * Checks if an edge exists between two specified vertices
     * @param val1 the first vertex 
     * @param val2 the second vertex that will now have an edge to the first
     * @return 0 if no edge exists, 1 if it exists and the graph is undirected, 
     * and the weight value for an edge that exists on a weighted graph
     */
    public double edgeExists(String val1, String val2) {
        Vertex v1 = new Vertex(val1);
        Vertex v2 = new Vertex(val2);
        for (Edge e : edges) 
        {
            if (e.equals(new Edge(v1, v2)) && type == Graph.graphType.UNDIRECTED) return 1;
            else if (e.equals(new Edge(v1, v2)) && type == Graph.graphType.WEIGHTED) return e.weight;
        }
        return 0;
    }
    /**
     * @param val1 the first vertex
     * @param val2 the second vertex 
     * @return the weight of the edge between specified vertices
     */
    public double getWeight(String val1, String val2) {
        return edgeExists(val1,val2);
    }
    /**
     * adds a new edge with specified vertex names
     * @param val1 the first vertex
     * @param val2 second vertex
     */
    public void insertEdge(String val1, String val2) {
        Vertex v1 = new Vertex(val1);
        Vertex v2 = new Vertex(val2);
        edges.add(new Edge(v1, v2));
        adjacencyList.get(v1).add(v2);
        adjacencyList.get(v2).add(v1);
    }
    /**
     * adds a new edge with vertex names and a weight
     * @param val1
     * @param val2
     * @param weight weight of this edge
     */
    public void insertEdge(String val1, String val2, double weight) {
        Vertex v1 = new Vertex(val1);
        Vertex v2 = new Vertex(val2);
        edges.add(new Edge(v1, v2, weight));
        adjacencyList.get(v1).add(v2);
        adjacencyList.get(v2).add(v1);
    }
    /**
     * rempves an edge from the graph between specified vertices
     * @param val1
     * @param val2
     */
    public Edge removeEdge(String val1, String val2) {
        Vertex v1 = new Vertex(val1);
        Vertex v2 = new Vertex(val2);
        Edge removed = null;
        for (Edge e : edges) 
        {
            if (e.equals(new Edge(v1, v2))) 
            {
                removed = edges.remove(edges.indexOf(e));
                break;
            }
        }
        List<Vertex> edgesV1 = adjacencyList.get(v1);
        List<Vertex> edgesV2 = adjacencyList.get(v2);
        if (edgesV1 != null)
            edgesV1.remove(v2);
        if (edgesV2 != null)
            edgesV2.remove(v1);
        return removed;
    }
    /**
     * Uses a breadth first traversing algorithm from a starting vertex
     * @param start the root vertex to begin at for traversal
     */
    public void traverse(String start) {
        Vertex startNode = new Vertex(start);
        Queue<Vertex> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.add(startNode);
        visited.add(startNode.label);
        
        while (!queue.isEmpty()) {
            Vertex current = queue.remove();
            System.out.println(current.label);
            
            for (Vertex v: adjacencyList.get(current)) { // Check each neighbor node
                if (!(visited.contains(v.label))) { // If neighbor node's value is not in visited set
                    queue.add(v);
                    visited.add(v.label);
                }
            }
        }
        System.out.println(visited);
    }
    




}
