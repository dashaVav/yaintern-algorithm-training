package algorithm_training.task_26;

import java.io.BufferedReader;
import java.io.FileReader;

//ссылка на задание https://contest.yandex.ru/contest/45468/problems/26/
public class task_26 {
    public static void main(String[] args) throws Exception {
        try (BufferedReader bf = new BufferedReader(new FileReader("src/main/java/algorithm_training/task_26/input.txt"))){
            var line = bf.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            int[][] mas = new int [n][m];
            int[][] paths = new int[n][m];

            for (int i = 0; i < n; i++) {
                var s = bf.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    mas[i][j] = Integer.parseInt(s[j]);
                }
            }

            paths[0][0] = mas[0][0];
            for (int i = 1; i < m; i++) paths[0][i] = mas[0][i] + paths[0][i - 1];
            for (int i = 1; i < n; i++) paths[i][0] = mas[i][0] + paths[i - 1][0];

            for (int i = 1; i < n; i ++) {
                for (int j = 1; j < m; j++) {
                    paths[i][j] = Math.min(paths[i - 1][j], paths[i][j - 1]) + mas[i][j];
                }
            }
            System.out.println(paths[n - 1][m - 1]);
        }
    }

}
