package  algorithm_training.task_38;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

//ссылка на задание https://contest.yandex.ru/contest/45468/problems/38/
//tl тест 6
public class Graph {

    private static class Edge{
        int x;
        int y;
        Edge(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    Boolean[] isVisited;

    Map<Edge, ArrayList<Edge>> adj = new HashMap<>();
    int n;
    int m;

    Graph(int n, int m)
    {
        this.n = n;
        this.m = m;
        isVisited = new Boolean[n];
        Arrays.fill(isVisited, false);
    }

    public void addEdge(Edge edge, Edge neighbour)
    {
        adj.computeIfAbsent(edge, k -> new ArrayList<>()).add(neighbour);
    }

    public void bfs(Integer s, Integer t, Integer n, Integer m, ArrayList<Edge> edges) {

        ArrayList<Edge> queue = new ArrayList<>();

        int[] dx = new int[] {1, -1, 1, -1, 2, 2, -2, -2};
        int[] dy = new int[] {2, 2, -2, -2, 1, -1, 1, -1};

        var counter = new int[n][m];
        for (int[] row: counter)
            Arrays.fill(row, -1);

        queue.add(new Edge(s, t));
        counter[s][t] = 0;

        while (queue.size() != 0) {
            var start = queue.remove(0);
            for (int i = 0; i < 8; i++){
                Edge edge = new Edge(start.x + dx[i], start.y + dy[i]);
                if (edge.x < m && edge.x > -1 && edge.y < n && edge.y > -1){
                    if (counter[start.x][start.y] + 1 < counter[edge.x][edge.y] || counter[edge.x][edge.y] == -1) {
                        counter[edge.x][edge.y] = counter[start.x][start.y] + 1;
                        queue.add(edge);
                    }
                }
            }
        }

        var count = 0;
        for(Edge edge : edges) {
            if (counter[edge.x][edge.y] != -1){
                count += counter[edge.x][edge.y];
            }
            else {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(count);
    }


    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/algorithm_training/task_38/input.txt"))) {
            var line = br.readLine().split(" ");
            var n = Integer.parseInt(line[0]);
            var m = Integer.parseInt(line[1]);

            var s = Integer.parseInt(line[2]) - 1;
            var t = Integer.parseInt(line[3]) - 1;


            Graph graph = new Graph(n, m);
            ArrayList<Edge> edges = new ArrayList<>();
            for (int i = 0; i < Integer.parseInt(line[4]); i++) {
                var mas = br.readLine().split(" ");
                edges.add(new Edge(Integer.parseInt(mas[0]) - 1, Integer.parseInt(mas[1]) - 1));
            }
            graph.bfs(s, t, n, m, edges);
        }
    }
}
