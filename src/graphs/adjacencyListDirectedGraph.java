package graphs;

import java.util.*;

public class adjacencyListDirectedGraph {
    static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int totalNodes, node;
        System.out.println("Enter total nodes ");
        totalNodes = scanner.nextInt();
        for (int i = 0; i < totalNodes; i++) {
            System.out.println("Enter node ");
            node = scanner.nextInt();
            adjList.put(node, new ArrayList<>());
        }

        addEdge(0, 1, true);
        addEdge(1, 2, true);
        addEdge(0, 2, true);
        printAdjacencyList();

    }


    static void addEdge(int u, int v, boolean directed) {
        //directed -0 - undirected graph
        //directed -1 - directed graph
        adjList.get(u).add(v);
        //undirected
        if (directed == false)
            adjList.get(v).add(u);
    }

    static void printAdjacencyList() {
        for (Map.Entry<Integer, List<Integer>> map : adjList.entrySet()) {
            System.out.println(map.getKey() + " -- " + map.getValue());
        }
    }
}
