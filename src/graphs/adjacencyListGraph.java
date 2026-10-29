
package graphs;

import java.util.*;

public class adjacencyListGraph {

    static HashMap<Integer, List<Integer>> adjList =
            new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter total nodes:");
        int totalNodes = scanner.nextInt();

        for (int i = 0; i < totalNodes; i++) {
            System.out.println("Enter node:");
            int node = scanner.nextInt();

            adjList.put(node, new ArrayList<>());
        }

        System.out.println("Enter total edges:");
        int totalEdges = scanner.nextInt();

        for (int i = 0; i < totalEdges; i++) {
            System.out.println("Enter source node u:");
            int u = scanner.nextInt();

            System.out.println("Enter destination node v:");
            int v = scanner.nextInt();

            addEdge(u, v, false);
        }

        printAdjacencyList();
        scanner.close();
    }

    static void addEdge(int u, int v, boolean directed) {

        if (!adjList.containsKey(u) || !adjList.containsKey(v)) {
            throw new IllegalArgumentException(
                    "Both nodes must exist in the graph"
            );
        }

        adjList.get(u).add(v);

        if (!directed) {
            adjList.get(v).add(u);
        }
    }

    static void printAdjacencyList() {
        for (Map.Entry<Integer, List<Integer>> entry
                : adjList.entrySet()) {
            System.out.println(
                    entry.getKey() + " -- " + entry.getValue()
            );
        }
    }
}
