package graphs.traversal;

import java.util.*;

public class dfs {
    static HashMap<Integer, List<Integer>> adjList = new HashMap<>();
    static boolean visited[];
    static Stack<Integer> ans = new Stack<>();

    public static void main(String[] args) {
        // 0, - > 1,3
        // 1 -> 2,3
        // 2 - > 3
        // 3
        int noOfNodes = 4;
        visited = new boolean[noOfNodes];
        int u;
        Scanner scanner = new Scanner(System.in);
        System.out.println("DFS traversal---");
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
                topologicalSort(i, visited,ans);
            }
        }
        System.out.println("Topological sort");
        while(!ans.isEmpty()){
            System.out.println(ans.peek());
            ans.pop();
        }

    }

    static void dfs(int source, boolean[] visited) {
        System.out.println(source);
        visited[source] = true;
        List<Integer> tempAns = adjList.get(source);
        for (Integer i : tempAns) {
            if (!visited[i]) {
                dfs(i, visited);
            }
        }

    }

    static void topologicalSort(int source, boolean[] visited,Stack<Integer> ans) {
        visited[source] = true;
        List<Integer> tempAns = adjList.get(source);
        for (Integer i : tempAns) {
            if (!visited[i]) {
                dfs(i, visited);
            }
        }
        //while returning store node in stack
        ans.push(source);

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
