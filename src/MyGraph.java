import java.util.*;
public class MyGraph<V> {
    private Map<Vertex, List<Edge<V>>> graph;
    public MyGraph(){
        graph = new HashMap<>();
    }
}
