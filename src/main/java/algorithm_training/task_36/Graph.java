package algorithm_training.task_36;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

//ссылка на задание https://contest.yandex.ru/contest/45468/problems/36/
public class Graph {
        Boolean[] isVisited;

        ArrayList<ArrayList<Integer> > adj;
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

        public int bfs(Integer start, Integer end) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            isVisited[start] = true;

            var counter = new int[n];
            Arrays.fill(counter, -1);

            queue.add(start);
            counter[start] = 0;
            while (!queue.isEmpty()) {
                start = queue.poll();

                for (Integer i : adj.get(start)) {
                    isVisited[i] = true;
                    if (counter[start] + 1 < counter[i] || counter[i] == -1) {
                        counter[i] = counter[start] + 1;
                        queue.add(i);
                    }
                }

            }
            return counter[end];
        }



    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\java\\algorithm_training\\task_36\\input.txt"))) {
            var count = Integer.parseInt(br.readLine());

            Graph graph = new Graph(count);
            for (int i = 0; i < count; i++) {
                var mas = br.readLine().split(" ");

                for (int j = 0; j < count; j++) {
                    if (Objects.equals(mas[j], "1")) graph.addEdge(i, j);
                }
            }
            var line = br.readLine().split(" ");
            System.out.println(graph.bfs(Integer.parseInt(line[0]) - 1, Integer.parseInt(line[1]) - 1));
        }
    }
}
