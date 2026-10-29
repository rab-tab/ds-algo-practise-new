
package graphs;

import java.util.*;

public class AdjacencyListWeightedGraph {

    static HashMap<Integer, List<Edge>> adjList = new HashMap<>();

    // Represents a neighbouring node and the edge weight
    static class Edge {
        int node;
        int weight;

        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + node + ", weight=" + weight + ")";
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Input nodes
        System.out.println("Enter total nodes:");
        int totalNodes = scanner.nextInt();

        for (int i = 0; i < totalNodes; i++) {
            System.out.println("Enter node:");
            int node = scanner.nextInt();

            if (adjList.containsKey(node)) {
                System.out.println("Node already exists. Enter a unique node.");
                i--;
                continue;
            }

            adjList.put(node, new ArrayList<>());
        }

        // Choose graph type
        System.out.println("Is the graph directed? (true/false):");
        boolean directed = scanner.nextBoolean();

        // Input edges
        System.out.println("Enter total edges:");
        int totalEdges = scanner.nextInt();

        for (int i = 0; i < totalEdges; i++) {

            System.out.println("Enter source node u:");
            int u = scanner.nextInt();

            System.out.println("Enter destination node v:");
            int v = scanner.nextInt();

            System.out.println("Enter edge weight:");
            int weight = scanner.nextInt();

            addEdge(u, v, weight, directed);
        }

        // Print adjacency list
        printAdjacencyList();

        scanner.close();
    }

    static void addEdge(int u, int v, int weight, boolean directed) {

        if (!adjList.containsKey(u) || !adjList.containsKey(v)) {
            throw new IllegalArgumentException(
                    "Both nodes must exist in the graph: " + u + ", " + v
            );
        }

        // Add edge u -> v with weight
        adjList.get(u).add(new Edge(v, weight));

        // For an undirected graph, add reverse edge v -> u
        if (!directed) {
            adjList.get(v).add(new Edge(u, weight));
        }
    }

    static void printAdjacencyList() {

        System.out.println("Adjacency List:");

        for (Map.Entry<Integer, List<Edge>> entry : adjList.entrySet()) {

            System.out.print(entry.getKey() + " --> ");

            for (Edge edge : entry.getValue()) {
                System.out.print(edge + " ");
            }

            System.out.println();
        }
    }
}
