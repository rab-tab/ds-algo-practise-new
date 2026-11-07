
package graphs.traversal;

import java.util.*;

public class dfs {

    static HashMap<Integer, List<Integer>> adjList = new HashMap<>();
    static Set<Integer> visited = new HashSet<>();

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

        System.out.println("DFS traversal:");

        // Handle disconnected components
        for (int node : adjList.keySet()) {

            if (!visited.contains(node)) {
                dfs(node);
            }
        }

        scanner.close();
    }

    static void dfs(int source) {

        visited.add(source);

        System.out.println(source);

        List<Integer> neighbours = adjList.get(source);

        for (int neighbour : neighbours) {

            if (!visited.contains(neighbour)) {
                dfs(neighbour);
            }
        }
    }

    private static void addEdge(int u, int v) {

        if (!adjList.containsKey(u) || !adjList.containsKey(v)) {
            throw new IllegalArgumentException("Node does not exist");
        }

        // Undirected graph
        adjList.get(u).add(v);
        adjList.get(v).add(u);
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
