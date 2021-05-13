/**
 * Vertex class
 * @author Dylan VanAllen
 */
public class Vertex {
    String label;
    
    /**
     * constructor for vertex object
     * @param label - contains only the name for the vertex
     */
    public Vertex(String l) {
        this.label = l;
    }
    
    /**
     * @override equals for use with collections
     * @param o object to compare
     * @return true if objects are the same
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o instanceof Vertex) == false) return false;
        Vertex v = (Vertex) o;
        return this.label.equals(v.label);
    }

    /**
     * @override hashcode for use with collections
     * @return the hashcode of this object
     */
    public int hashCode() {
        return this.label.hashCode();
    }
}

