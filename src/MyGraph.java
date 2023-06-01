import java.util.*;
public class MyGraph<V> {
    private Map<Vertex, List<Edge<V>>> graph;
    public MyGraph(){
        graph = new HashMap<>();
    }
// Method for add edge with weight beetwen source and destination vertices
    public void addEdge(Vertex source, Vertex destination, double weight){
        Edge edge = new Edge(source, destination, weight);
        source.addAdjVertex(destination, weight);
        if (!graph.containsKey(source)) graph.put(source,new ArrayList<>());
        graph.get(source).add(edge);
    }

    // Method for show graph with vertex and edge information
    public void showGraph(){
        for (Map.Entry<Vertex, List<Edge<V>>> entry : graph.entrySet()){
            Vertex<V> vertex = entry.getKey();
            List<Edge<V>> edges = entry.getValue();
            System.out.println(vertex + ">");
            for (Edge<V> edge : edges){
                Vertex<V> destination = edge.getDest();
                double weight = edge.getWeight();
                System.out.println(destination + "(" + weight + ")");
            }
        }
    }

    //Method for search data present in Graph
    public boolean search(Vertex start, V target){
        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);
        while(!queue.isEmpty()){
            Vertex currVertex = queue.poll();
            if (currVertex.getData().equals(target)){
                return true;
            }
            Set<Vertex<V>> neighbors = currVertex.getAdjVertices().keySet();
            for (Vertex<V> neighbour : neighbors){
                if (!visited.contains(neighbour)){
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        return false;
    }


}
