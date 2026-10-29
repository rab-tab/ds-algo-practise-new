
package graphs.traversal;

import java.util.*;

public class bfsApproach1 {

    static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter total nodes:");
        int noOfNodes = scanner.nextInt();

        // Input nodes
        for (int i = 0; i < noOfNodes; i++) {
            System.out.println("Enter node:");
            int node = scanner.nextInt();

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

        System.out.println("Enter source node for BFS:");
        int source = scanner.nextInt();

        bfsTraversal(source);

        scanner.close();
    }

    private static void addEdge(int u, int v) {

        if (!adjList.containsKey(u) || !adjList.containsKey(v)) {
            throw new IllegalArgumentException("Node does not exist");
        }

        // Undirected graph
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    private static void bfsTraversal(int source) {

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        q.add(source);
        visited.add(source);

        while (!q.isEmpty()) {

            int temp = q.remove();
            System.out.println(temp);

            for (int neighbour : adjList.get(temp)) {
                if (!visited.contains(neighbour)) {
                    q.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }
    }

    private static void printAdjList() {
        for (Map.Entry<Integer, List<Integer>> entry
                : adjList.entrySet()) {
            System.out.println(
                    entry.getKey() + " --> " + entry.getValue()
            );
        }
    }
}
