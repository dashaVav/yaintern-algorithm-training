package algorithm_training.task_5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

//ссылка на задание https://contest.yandex.ru/contest/45468/problems/5/
public class task_5 {
    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new FileReader("src/main/java/algorithm_training/task_5/input.txt"))){
            var n = Integer.parseInt(bf.readLine());
            long result = 0;

            int[] alphabet = new int[n];
            Set<Integer> priority = new TreeSet<>();
            for (int i = 0; i < n; i ++) {
                alphabet[i] = Integer.parseInt(bf.readLine());
                priority.add(alphabet[i]);
            }

            long prev = 0;
            for (Integer level : priority) {
                int seq = 0;
                for (int i = 0; i < n - 1; i ++) {
                    seq = alphabet[i] >= level && alphabet[i + 1] >= level ? seq + 1 : seq;
                }
                result += seq * (level - prev);
                prev = level;
            }
            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
