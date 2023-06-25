package graphs;

import java.util.Scanner;

public class adjacencyMatrixUndirectedWeighted {
    public static void main(String[] args) {
        int nodes = 3;
        int noOfEdges = 6;
        int[][] adj = new int[nodes][nodes];
        Scanner scanner;
        int u, v, w;
        for (int i = 0; i < noOfEdges; i++) {
            scanner = new Scanner(System.in);
            System.out.println("Enter u ");
            u = scanner.nextInt();
            System.out.println("Enter v ");
            v = scanner.nextInt();
            System.out.println("Enter weight - w  ");
            w = scanner.nextInt();
            adj[u][v] = w;
        }
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }

    }
}
