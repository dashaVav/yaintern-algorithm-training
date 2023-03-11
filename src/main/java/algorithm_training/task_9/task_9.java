package algorithm_training.task_9;

import java.io.BufferedReader;
import java.io.FileReader;

public class task_9 {
    public static void main(String[] args) throws Exception {
        try (BufferedReader bf = new BufferedReader(new FileReader("src/main/java/algorithm_training/task_9/input.txt"))){
            var str = bf.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            int k = Integer.parseInt(str[2]);
            int[][] matrix = new int[n + 1][m + 1];

            for (int i = 1; i <= n; i++) {
                str = bf.readLine().split(" ");
                for (int j = 1; j <= m; j++) {
                    matrix[i][j] = Integer.parseInt(str[j - 1]) + matrix[i - 1][j] + matrix[i][j - 1] - matrix[i - 1][j - 1];
                }
            }

            for (int i = 0; i < k; i++) {
                str = bf.readLine().split(" ");
                int x1 = Integer.parseInt(str[0]);
                int y1 = Integer.parseInt(str[1]);
                int x2 = Integer.parseInt(str[2]);
                int y2 = Integer.parseInt(str[3]);
                int sum = matrix[x2][y2] + matrix[x1 - 1][y1 - 1] - matrix[x1 - 1][y2] - matrix[x2][y1 - 1];
                System.out.println(sum);
            }

        }
    }
}
