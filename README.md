# MyGraph
## addEdge
``` java
    public void addEdge(Vertex source, Vertex destination, double weight){
        Edge edge = new Edge(source, destination, weight);
        source.addAdjVertex(destination, weight);
        if (!graph.containsKey(source)) graph.put(source,new ArrayList<>());
        graph.get(source).add(edge);
    }
```
Description : Adds an edge with a weight between the source and destination vertices.
<br/>
<hr/>
## showGraph
``` java
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
```
Description : Displays the graph information, including vertices and edges.
## seacrh
``` java 
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

    // This method also for seacrh and check
    public boolean search(Vertex<V> start, Vertex<V> target) {
        Set<Vertex<V>> visited = new HashSet<>();
        Queue<Vertex<V>> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> currentVertex = queue.poll();
            if (currentVertex.equals(target)) {
                return true;
            }

            Map<Vertex<V>, Double> adjVertices = currentVertex.getAdjVertices();
            for (Vertex<V> neighbor : adjVertices.keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return false;
    }
```
Description : Searches for the specified target data/vertex within the graph starting from the given start vertex. Returns true if the target data is found, otherwise false.

<br/>
<hr/>
## DijkstraSearch
``` java
    public Map<Vertex, Double> DijkstraSearch(Vertex start) {
        Map<Vertex, Double> distances = new HashMap<>();
        for (Vertex node : graph.keySet()) {
            distances.put(node, Double.POSITIVE_INFINITY);
        }
        distances.put(start, 0d);
        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        queue.add(start);
        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            List<Edge<V>> neighbors = graph.get(currentVertex);
            if (neighbors == null) {
                continue;
            }
            for (Edge<V> neighbor : neighbors) {
                Vertex<V> destination = neighbor.getDest();
                Double currentDistance = distances.get(currentVertex);
                if (currentDistance == null) {
                    continue;
                }
                double distance = currentDistance + neighbor.getWeight();
                Double destinationDistance = distances.get(destination);
                if (destinationDistance == null || distance < destinationDistance) {
                    distances.put(destination, distance);
                    queue.add(destination);
                }
            }
        }
        return distances;
    }
```
Description : Performs Dijkstra's shortest path algorithm starting from the specified start vertex. Returns a map containing the distances from the start vertex to all other vertices in the graph.
<br/>
<hr/>
## BFS
``` java
    public void BFS(Vertex<V> start) {
        Set<Vertex<V>> visited = new HashSet<>();
        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            Vertex<V> currentVertex = queue.poll();
            System.out.print(currentVertex + " ");
            Map<Vertex<V>, Double> adjVertices = currentVertex.getAdjVertices();
            for (Vertex<V> neighbor : adjVertices.keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
```
Description : Conducts a breadth-first search (BFS) starting from the specified start vertex. Prints the visited vertices in breadth-first order.
<hr/>
