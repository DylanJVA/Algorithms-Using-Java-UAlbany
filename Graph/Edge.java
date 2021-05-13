/**
 * Edge class describes an edge between two vertices
 */
public class Edge {
    Vertex v1;
    Vertex v2;
    double weight;
    /**
     * edge constructor to create a new unweighted edge between two vertices
     * @param v1
     * @param v2
     */
    public Edge(Vertex v1, Vertex v2) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = 1;
    }
    /**
     * edge constructor to create a new weighted edge
     * @param v1
     * @param v2
     * @param weight
     */
    public Edge(Vertex v1, Vertex v2, double weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }
    /**
     * @override equals method
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o instanceof Edge) == false) return false;
        Edge e = (Edge) o;
        if ((e.v1.equals(this.v1) && e.v2.equals(this.v2)) || (e.v1.equals(this.v2) && e.v2.equals(this.v1))) return true;
        else return false;
    }
    /**
     * @override haschode for collections
     */
    public int hashCode() {
        return this.hashCode();
    }

}