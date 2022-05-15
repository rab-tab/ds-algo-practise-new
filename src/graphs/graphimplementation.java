package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class graphimplementation {
    static int V = 5;
    static ArrayList<ArrayList<Integer>> adj
            = new ArrayList<ArrayList<Integer>>(V);

    // no of nodes , edges
    public static void main(String[] args) {

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        // Adding edges one by one
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        System.out.println("adj size " + adj.size());
        printList();

    }


    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        // 0 - undirected
        // 1- directed
        adj.get(u).add(v);
        adj.get(v).add(u);

    }

    public static void printList() {
        System.out.println("IN print list");
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex"
                    + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> "
                        + adj.get(i).get(j));
            }
            System.out.println();
        }
    }
}
