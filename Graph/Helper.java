/**
 * Helper class tests cases for the graph adt
 * @author Dylan VanAllen
 */
import java.util.*;
public class Helper {
    /**
     * start method runs all the test code
     */
    public static void start() {
        System.out.println("Undirected graph test: \n");
        undirectedGraphTest();
        System.out.println("------------------------\nWeighted graph test: \n");
        weightedGraphTest();
    }
    /**
     * tests an undirected graph
     */
    public static void undirectedGraphTest() {
        
        Graph graph = new Graph(Graph.graphType.UNDIRECTED);
        System.out.println("The graph is empty: "+graph.isEmpty());
        System.out.println("Building graph...");
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        graph.insertEdge("A", "B");
        graph.insertEdge("A", "C");
        graph.insertEdge("B", "D");
        graph.insertEdge("C", "D");
        graph.insertEdge("B", "E");
        graph.insertEdge("D", "E");
        System.out.println("The graph is empty: "+graph.isEmpty());
        System.out.println("Number of vertices: "+graph.numVertices());
        System.out.println("Number of edges: "+graph.numEdges());
        if (graph.edgeExists("A","B") == 1)
            System.out.println("An edge exists between A and B");
        else System.out.println("An edge does not exist between A and B");

        if (graph.edgeExists("A","D") == 1)
            System.out.println("An edge exists between A and D");
        else System.out.println("An edge does not exist between A and D");
        
        graph.traverse("C");
    }
    /**
     * tests a weighted graph
     */
    public static void weightedGraphTest() {
        
        Graph graph = new Graph(Graph.graphType.WEIGHTED);
        System.out.println("The graph is empty: "+graph.isEmpty());
        System.out.println("Building graph...");
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        graph.insertEdge("A", "C", 2);
        graph.insertEdge("A", "E", 4);
        graph.insertEdge("B", "D", 1.5);
        graph.insertEdge("A", "D", 6);
        graph.insertEdge("B", "E", 3);
        graph.insertEdge("D", "E", 5);
        System.out.println("The graph is empty: "+graph.isEmpty());
        System.out.println("Number of vertices: "+graph.numVertices());
        System.out.println("Number of edges: "+graph.numEdges());
        if (graph.edgeExists("A","B") > 0)
            System.out.println("An edge exists between A and B with weight: "+graph.getWeight("A","B"));
        else System.out.println("An edge does not exist between A and B");

        if (graph.edgeExists("A","D") > 0)
            System.out.println("An edge exists between A and D with weight: "+graph.getWeight("A","D"));
        else System.out.println("An edge does not exist between A and D");
        
        graph.traverse("C");
    }
}
