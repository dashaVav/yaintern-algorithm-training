package algorithm_training.task_8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//ссылка на задание https://contest.yandex.ru/contest/45468/problems/8/
public class task_8 {
    public static void main(String[] arg) {
        try (BufferedReader bf = new BufferedReader(new FileReader("src/main/java/algorithm_training/task_8/input.txt"))){
            var n = Integer.parseInt(bf.readLine());
            String s;
            int max_x = -1, max_y = -1, min_y = (int) Math.pow(10, 9), min_x = (int) Math.pow(10, 9);
            while ((s = bf.readLine()) != null) {
                var xy = s.split(" ");
                max_x = Math.max(max_x, Integer.parseInt(xy[0]));
                min_x = Math.min(min_x, Integer.parseInt(xy[0]));
                max_y = Math.max(max_y, Integer.parseInt(xy[1]));
                min_y = Math.min(min_y, Integer.parseInt(xy[1]));
            }
            System.out.printf("%d %d %d %d%n", min_x, min_y, max_x, max_y);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
