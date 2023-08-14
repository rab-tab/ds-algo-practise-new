package graphs.traversal;

import java.util.*;

public class bfs_disconnected_graph {
    static HashMap<Integer, List<Integer>> adjList = new HashMap<>();
    static boolean visited[];

    public static void main(String[] args) {
        // 0, - > 1,3
        // 1 -> 2,3
        // 2 - > 3
        // 3
        int noOfNodes = 4;
        visited = new boolean[noOfNodes];
        int u;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Disconnected graph---");
        for (int i = 0; i < noOfNodes; i++) {
            System.out.println("Enter the node");
            u = scanner.nextInt();
            adjList.put(u, new ArrayList<>());
        }
        addEdge(0, 1);
        addEdge(0, 3);
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(2, 3);
        printAdjList();
        for (int i = 0; i < noOfNodes; i++) {
            if (!visited[i]) {
                bfsTraversal(i, visited);
            }
        }

    }

    private static void bfsTraversal(int source, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;
        while (!q.isEmpty()) {
            int temp = q.peek();
            q.remove();
            System.out.println(temp);
            List<Integer> tempAns = adjList.get(temp);
            for (Integer i : tempAns) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static void printAdjList() {
        for (Map.Entry<Integer, List<Integer>> map : adjList.entrySet())
            System.out.println(map.getKey() + "--- " + map.getValue());
    }

    private static void addEdge(int u, int v) {

        adjList.get(u).add(v);
        adjList.get(v).add(v);


    }
}
