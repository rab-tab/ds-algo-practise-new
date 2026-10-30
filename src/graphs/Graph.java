package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    public static int V;
    public  static LinkedList<Integer> adj[];

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    //traversal from starting source s
    public void BFS(int s) {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];
        //queue for BFS

        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            //dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
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

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }


    public int shortestPathBFS(int source, int destination) {

            boolean[] visited = new boolean[V];
            int[] distance = new int[V];

            Queue<Integer> queue = new LinkedList<>();
            visited[source] = true;
            distance[source] = 0;
            queue.add(source);

            while (!queue.isEmpty()) {
                int currentNode = queue.poll();

                if (currentNode == destination) {
                    return distance[currentNode];
                }

                for (int neighbor : adj[currentNode]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        distance[neighbor] = distance[currentNode] + 1;
                        queue.add(neighbor);
                    }
                }
            }

            return -1; // Return -1 if there is no path from source to destination
    }
}

