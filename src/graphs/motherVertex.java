package graphs;

import java.util.Iterator;

import static graphs.Graph.V;
import static graphs.Graph.adj;

public class motherVertex {
    public static Graph g;
    public static int motherVertex;

    public static void main(String[] args) {
        g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");

        g.DFS(2);
        System.out.println("Motehr vertext is " + motherVertex);
    }


    void DFS(int s) {
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper
        // function to print DFS
        // traversal
        DFSUtil(s, visited);
    }

    // A function used by DFS
    void DFSUtil(int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");
        int last_dfs = 0;

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
                last_dfs = n;
            }
        }

        for (int k = 0; k < visited.length; k++) {
            visited[k] = false;
        }

        DFSUtil(last_dfs, visited);
        for (int k = 0; k < visited.length; k++) {
            if (visited[k] == false) motherVertex = -1;
            return;
        }
        motherVertex = last_dfs;

    }
}
