package algorithm_training.task_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//ссылка на задание https://contest.yandex.ru/contest/45468/problems/2/
public class task_2 {
    public static void main(String[] arg) {
        try (BufferedReader bf = new BufferedReader(new FileReader("input.txt"))){
            var n = Integer.parseInt(bf.readLine());
            char [] line = bf.readLine().toCharArray();
            int[] alf = new int[26];
            int max = 0;
            int index = 0;
            for (int i = 0; i < line.length; i ++) {
                max = Math.max(max, ++alf[line[i] - 'a']);
                if (max + n - 1 < i - index) alf[line[index++] - 'a'] --;
            }
            System.out.println(line.length - index);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
