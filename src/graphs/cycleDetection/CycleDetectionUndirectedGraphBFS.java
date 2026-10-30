package graphs.cycleDetection;


import java.util.*;

public class CycleDetectionUndirectedGraphBFS {

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

        // Undirected graph
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    private static boolean detectCycle() {

        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();

        // Check every component, including disconnected components
        for (int source : adjList.keySet()) {

            if (visited.contains(source)) {
                continue;
            }

            // Each queue entry stores {current node, parent node}
            queue.add(new int[]{source, -1});
            visited.add(source);

            while (!queue.isEmpty()) {

                int[] current = queue.remove();

                int node = current[0];
                int parent = current[1];

                for (int neighbour : adjList.get(node)) {

                    if (!visited.contains(neighbour)) {
                        visited.add(neighbour);
                        queue.add(new int[]{neighbour, node});
                    } else if (neighbour != parent) {
                        // Visited neighbour is not the parent:
                        // a cycle exists
                        return true;
                    }
                }
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
