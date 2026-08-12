package graphs;

import kotlin.collections.ArraysKt;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AdvanceGraph {
    public static class Edge {
        int src;
        int des;

        public Edge(int s, int d) {
            this.src = s;
            this.des = d;
        }

    }

    /*
               1 ----- 3                  8
             /         | \              /  \
           0           |  5 ---- 6     7    9
             \         | /
               2 ----- 4
     */

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));


        // Second disconnected component
        graph[7].add(new Edge(7, 8));

        graph[8].add(new Edge(8, 7));
        graph[8].add(new Edge(8, 9));

        graph[9].add(new Edge(9, 8));
    }

    public static void main(String[] args) {
        int V = 10;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);
        boolean[] visited = new boolean[V];
        System.out.print("BFS: ");
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                bfs(graph, i, visited);
            }
        }

        System.out.println();
        System.out.println("---------------------------------");
//        boolean[] visited2 = new boolean[graph.length];
        Arrays.fill(visited, false);

        System.out.print("DFS: ");
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited);
            }
        }

        System.out.println();
        Arrays.fill(visited, false);
        allPath(graph, 0, visited, "", 5);



    }

    public static void bfs(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(src);
        visited[src] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + "  ");
            for (Edge edge : graph[curr]) {
                if (!visited[edge.des]) {
                    visited[edge.des] = true;
                    queue.add(edge.des);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] visited) {
        System.out.print(curr + "  ");
        visited[curr] = true;

        for (Edge e : graph[curr]) {
            if (!visited[e.des]) {
                dfs(graph, e.des, visited);
            }
        }
    }

    public static void allPath(ArrayList<Edge>[] graph, int curr, boolean[] visited,
                               String path, int target) {

        if (curr == target) {
            System.out.println(path + curr);
            return;
        }

        visited[curr] = true;

        for (Edge e : graph[curr]) {
            if (!visited[e.des]) {
                allPath(graph, e.des, visited, path + curr + " -> ", target);
            }
        }
        visited[curr] = false;
    }
}
