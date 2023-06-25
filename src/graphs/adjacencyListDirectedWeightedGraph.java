package graphs;

import java.util.*;

public class adjacencyListDirectedWeightedGraph {
    static HashMap<Integer, List<Pair<Integer, Integer>>> adjList = new HashMap<>();

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

        addEdge(0, 1, 1, true);
        addEdge(1, 2, 2, true);
        addEdge(0, 2, 3, true);
        printAdjacencyList();

    }


    static void addEdge(int u, int v, int w, boolean directed) {
        //directed -0 - undirected graph
        //directed -1 - directed graph
        adjList.get(u).add(new Pair<>(v, w));
        //undirected
        if (directed == false)
            adjList.get(v).add(new Pair<>(v, w));
    }

    static void printAdjacencyList() {
        for (Map.Entry<Integer, List<Pair<Integer, Integer>>> map : adjList.entrySet()) {
            System.out.print(map.getKey() + " --> ");
            List<Pair<Integer, Integer>> val = map.getValue();
            for (Pair p : val) {
                System.out.print(p.n1 + " , "+p.n2);
            }
            System.out.println();
        }
    }
}
