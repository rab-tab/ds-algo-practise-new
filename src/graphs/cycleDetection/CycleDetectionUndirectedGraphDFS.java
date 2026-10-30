
package graphs.cycleDetection;

import java.util.*;

public class CycleDetectionUndirectedGraphDFS {

    static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Input nodes
        System.out.println("Enter total nodes:");
        int noOfNodes = scanner.nextInt();

        for (int i = 0; i < noOfNodes; i++) {
            System.out.println("Enter node:");
            int node = scanner.nextInt();

            if (adjList.containsKey(node)) {
                System.out.println("Duplicate node. Enter a unique node.");
                i--;
                continue;
            }

            adjList.put(node, new ArrayList<>());
        }

        // Input edges
        System.out.println("Enter total edges:");
        int noOfEdges = scanner.nextInt();

        for (int i = 0; i < noOfEdges; i++) {
            System.out.println("Enter u:");
            int u = scanner.nextInt();

            System.out.println("Enter v:");
            int v = scanner.nextInt();

            addEdge(u, v);
        }

        printAdjList();

        boolean hasCycle = detectCycle();

        if (hasCycle) {
            System.out.println("Cycle detected");
        } else {
            System.out.println("No cycle detected");
        }

        scanner.close();
    }

    private static void addEdge(int u, int v) {

        if (!adjList.containsKey(u) || !adjList.containsKey(v)) {
            throw new IllegalArgumentException("Node does not exist");
        }

        // Undirected graph: add both directions
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    private static boolean detectCycle() {

        Set<Integer> visited = new HashSet<>();

        // Check every connected component
        for (int node : adjList.keySet()) {

            if (!visited.contains(node)) {
                if (dfs(node, -1, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(
            int node,
            int parent,
            Set<Integer> visited) {

        visited.add(node);

        for (int neighbour : adjList.get(node)) {

            if (!visited.contains(neighbour)) {

                if (dfs(neighbour, node, visited)) {
                    return true;
                }

            } else if (neighbour != parent) {

                // Visited neighbour is not the parent
                return true;
            }
        }

        return false;
    }

    private static void printAdjList() {

        System.out.println("Adjacency List:");

        for (Map.Entry<Integer, List<Integer>> entry
                : adjList.entrySet()) {

            System.out.println(
                    entry.getKey() + " --> " + entry.getValue()
            );
        }
    }
}
