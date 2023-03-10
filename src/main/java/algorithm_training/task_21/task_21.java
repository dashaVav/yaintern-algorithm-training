package algorithm_training.task_21;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

//ссылка на задание https://contest.yandex.ru/contest/45468/problems/21/
public class task_21 {
    public static void main(String[] arg) {
        var n = new Scanner(System.in).nextInt();
        if (n == 1) {
            System.out.println(2);
        }
        else if (n == 2){
            System.out.println(4);
        }
        else {
            Map<Integer, Integer> map = new HashMap<>();
            IntStream.rangeClosed(0, 3).forEach(num -> map.put(num, 1));
            for(int i = 0; i < n - 2; i++) {
                Integer num0 = map.get(0), num1 = map.get(1), num2 = map.get(2), num3 = map.get(3);
                map.put(0, num0 + num2);
                map.put(1, num0 + num2);
                map.put(2, num1 + num3);
                map.put(3, num1);
            }
            System.out.println(map.get(0) + map.get(1) + map.get(2) + map.get(3));
        }
    }
}
