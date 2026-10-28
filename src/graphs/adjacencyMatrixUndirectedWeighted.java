
package graphs;

import java.util.Scanner;

public class adjacencyMatrixUndirectedWeighted {

    public static void main(String[] args) {

        int nodes = 3;
        int noOfEdges = 3;

        int[][] adj = new int[nodes][nodes];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < noOfEdges; i++) {

            System.out.println("Enter u:");
            int u = scanner.nextInt();

            System.out.println("Enter v:");
            int v = scanner.nextInt();

            System.out.println("Enter weight:");
            int weight = scanner.nextInt();

            // Undirected weighted graph
            adj[u][v] = weight;
            adj[v][u] = weight;
        }

        System.out.println("Adjacency Matrix:");

        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
