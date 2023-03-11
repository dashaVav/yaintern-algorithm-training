package algorithm_training.task_28;

import java.util.Scanner;

//ссылка на задание https://contest.yandex.ru/contest/45468/problems/28/
public class task_28 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        var n = scan.nextInt();
        var m = scan.nextInt();
        int[][] data = new int[n][m];
        data[0][0] = 1;
        for (int i = 1; i < n; i ++){
            for (int j = 1; j < m; j ++){
                if (i > 1) data[i][j] += data[i - 2][j - 1];
                if (j > 1) data[i][j] += data[i - 1][j - 2];
            }
        }
        System.out.println(data[n - 1][m - 1]);
    }
}
