package algorithm_training.task_22;

import java.util.Scanner;

//ссылка на задание https://contest.yandex.ru/contest/45468/problems/22/
public class task_22 {
    public static void main(String[] arg) {
        var line = new Scanner(System.in).nextLine().split(" ");
        var n = Integer.parseInt(line[0]);
        var k = Integer.parseInt(line[1]);
        int[] mas = new int[n + 1];
        mas[1] = 1;
        for (int i = 2; i < n + 1; i ++) {
            var x = i - 1;
            var step = 1;
            while (x > 0 && k >= step) {
                mas[i] += mas[x];
                x --;
                step ++;
            }
        }
        System.out.println(mas[mas.length - 1]);
    }
}
