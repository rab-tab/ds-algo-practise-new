package graphs;

import java.util.Scanner;

public class adjacencyMatrix {
    public static void main(String[] args) {
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
            adj[u][v] = 1;
        }
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }

    }
}
