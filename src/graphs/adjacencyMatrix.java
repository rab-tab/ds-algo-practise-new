package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class adjacencyMatrix {
    public static void main(String[] args) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        int nodes = 3;
        int noOfEdges = 6;
        int[][] adj = new int[nodes][nodes];
        Scanner scanner;
        int u, v;
        for (int i = 0; i < noOfEdges; i++) {
            scanner = new Scanner(System.in);
            System.out.println("Enter u ");
            u = scanner.nextInt();
            System.out.println("Enter v ");
            v = scanner.nextInt();
            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            System.out.println("u --- "+u + "v----- "+v);

        }
        //print adjacency list
        System.out.println("Adjacency list -----------------");
        for (HashMap.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }
        for(int i=0;i<adj.length;i++){
            for(int j=0;j<adj[i].length;j++){
                if(adjList.containsKey(i) && adjList.get(i).contains(j))
                     adj[i][j] = 1;
                else
                    adj[i][j] = 0;
            }
        }
        System.out.println("Graph -----------------");
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }

    }
}
