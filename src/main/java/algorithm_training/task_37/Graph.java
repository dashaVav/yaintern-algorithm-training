package algorithm_training.task_37;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

//ссылка на задание https://contest.yandex.ru/contest/45468/problems/37/?success=83755822#30404/2017_05_21/zrMZYXXRUS
public class Graph {
    Boolean[] isVisited;

    ArrayList<ArrayList<Integer>> adj;
    int n;

    Graph(int n)
    {
        this.n = n;
        adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        isVisited = new Boolean[n];
        Arrays.fill(isVisited, false);
    }

    public void addEdge(Integer edge, Integer neighbour)
    {
        adj.get(edge).add(neighbour);
    }

    public void bfs(Integer start, Integer end) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        isVisited[start] = true;

        var counter = new int[n];
        Arrays.fill(counter, -1);

        var parent = new int[n];
        parent[start] = -1;

        queue.add(start);
        counter[start] = 0;
        while (queue.size() != 0) {
            start = queue.poll();
            for (Integer i : adj.get(start)) {
                isVisited[i] = true;
                if (counter[start] + 1 < counter[i] || counter[i] == -1) {
                    counter[i] = counter[start] + 1;
                    parent[i] = start;
                    queue.add(i);
                }
            }
        }

        System.out.println(counter[end]);

        if (counter[end] <= 0) return;
        ArrayList<Integer> path = new ArrayList<>();
        path.add(end + 1);
        var t = parent[end];
        while (t != -1) {
            path.add(t + 1);
            t = parent[t];
        }

        Collections.reverse(path);

        for (Integer n : path) {
            System.out.format("%d ", n);
        }

    }



    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\java\\algorithm_training\\task_37\\input.txt"))) {
            var count = Integer.parseInt(br.readLine());

            Graph graph = new Graph(count);
            for (int i = 0; i < count; i++) {
                var mas = br.readLine().split(" ");

                for (int j = 0; j < count; j++) {
                    if (Objects.equals(mas[j], "1")) graph.addEdge(i, j);
                }
            }
            var line = br.readLine().split(" ");
            graph.bfs(Integer.parseInt(line[0]) - 1, Integer.parseInt(line[1]) - 1);
        }
    }
}
