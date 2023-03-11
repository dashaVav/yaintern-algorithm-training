package algorithm_training.task_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//ссылка на задание https://contest.yandex.ru/contest/45468/problems/4/
public class task_4 {
    public static void main(String[] arg) {
        try (BufferedReader bf = new BufferedReader(new FileReader("src/main/java/algorithm_training/task_4/input.txt"))){
            var n = Integer.parseInt(bf.readLine());
            var k = Integer.parseInt(bf.readLine());
            var row = Integer.parseInt(bf.readLine());
            var pos = Integer.parseInt(bf.readLine());

            int var = k % 2;
            int nextRow = row + k / 2;
            int prevRow = row - k / 2;
            int nextPos = pos;
            int prevPos = pos;

            if (var == 1) {
                if (pos + 1 > 2) {
                    nextRow ++;
                    nextPos = 1;
                }
                else {
                    nextPos = 2;
                }
                if (pos - 1 < 1) {
                    prevRow--;
                    prevPos = 2;
                }
                else {
                    prevPos = 1;
                }
            }

            boolean prev = prevRow > 0;
            boolean next = (nextRow - 1) * 2 + nextPos - 1 < n;

            if (prev && next) {
                int dPrev = row - prevRow;
                int dNext = nextRow - row;
                System.out.println(dPrev < dNext ? prevRow + " " + prevPos : nextRow + " " + nextPos);
            }
            else if (!prev && next) System.out.println(nextRow + " " + nextPos);
            else if (prev) System.out.println(prevRow + " " + prevPos);
            else System.out.println(-1);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
