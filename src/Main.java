public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Assignment 6");
        MyGraph<Integer> myGraph = new MyGraph<>();
        Vertex<Integer> x1 = new Vertex<>(1);
        Vertex<Integer> x2 = new Vertex<>(2);
        Vertex<Integer> x3 = new Vertex<>(3);
        Vertex<Integer> x4 = new Vertex<>(4);
        Vertex<Integer> x5 = new Vertex<>(5);
        myGraph.addEdge(x1, x2, 5d);
        myGraph.addEdge(x1, x3, 6d);
        myGraph.addEdge(x2, x4, 7d);
        myGraph.addEdge(x2, x5, 8d);

        myGraph.DijkstraSearch(x1);
        myGraph.BFS(x2);
    }
}