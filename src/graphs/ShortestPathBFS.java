package graphs;


import java.util.*;

public class ShortestPathBFS {

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

        System.out.println("Enter source:");
        int source = scanner.nextInt();

        System.out.println("Enter destination:");
        int destination = scanner.nextInt();

        if (!adjList.containsKey(source) ||
                !adjList.containsKey(destination)) {

            System.out.println("Invalid source or destination");

        } else {

            int distance = shortestPathBFS(source, destination);

            if (distance == -1) {
                System.out.println("No path exists");
            } else {
                System.out.println("Shortest distance: " + distance);
            }
        }

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

    public static int shortestPathBFS(int source, int destination) {

        Set<Integer> visited = new HashSet<>();

        Map<Integer, Integer> distance = new HashMap<>();

        Queue<Integer> queue = new LinkedList<>();

        visited.add(source);
        distance.put(source, 0);
        queue.add(source);

        while (!queue.isEmpty()) {

            int currentNode = queue.poll();

            if (currentNode == destination) {
                return distance.get(currentNode);
            }

            for (int neighbour : adjList.get(currentNode)) {

                if (!visited.contains(neighbour)) {

                    visited.add(neighbour);

                    distance.put(
                            neighbour,
                            distance.get(currentNode) + 1
                    );

                    queue.add(neighbour);
                }
            }
        }

        return -1;
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
