import java.util.*;
public class MyGraph<V> {
    private Map<Vertex, List<Edge<V>>> graph;
    public MyGraph(){
        graph = new HashMap<>();
    }

    public void addEdge(Vertex source, Vertex destination, double weight){
        Edge edge = new Edge(source, destination, weight);
    }
}
