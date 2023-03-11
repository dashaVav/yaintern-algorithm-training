package algorithm_training.task_25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

//ссылка на задание https://contest.yandex.ru/contest/45468/problems/25/
public class task_25 {
    public static void main(String[] args) throws Exception {
        try (BufferedReader bf = new BufferedReader(new FileReader("src/main/java/algorithm_training/task_25/input.txt"))) {
            int n = Integer.parseInt(bf.readLine());
            var line = bf.readLine().split(" ");

            int[] data = new int[n + 1];

            for(int i = 0; i < n; i++) {
                data[i + 1] = Integer.parseInt(line[i]);
            }

            Arrays.sort(data);
            var len = new int[n + 1];
            Arrays.fill(len, 0);

            for (int i = 2; i < n + 1; i++) {
                if (i <= 3) len[i] = data[i] - data[1];
                else len[i] = Math.min(len[i - 1], len[i - 2]) + data[i] - data[i - 1];
            }
            System.out.println(len[n]);
        }
    }
}
