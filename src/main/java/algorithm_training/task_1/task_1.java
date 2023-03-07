package algorithm_training.task_1;

import java.io.*;
import java.util.*;

//ссылка на задание https://contest.yandex.ru/contest/45468/problems/1/
public class task_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

        Map<String, Integer> map = new TreeMap<>();
        String file;

        while ((file = reader.readLine()) != null) {
            String[] nums = file.split("");

            for (String i: nums) {
                if (map.containsKey(i)) map.put(i, map.get(i) + 1);
                else map.put(i, 1);
            }

        }

        map.remove(" ");
        map.remove("");
        int max = 0;
        for(Map.Entry<String, Integer> i : map.entrySet()) {
            if (i.getValue() > max) max = i.getValue();
        }

        for (int i = max; i > 0; i--) {
            for(Map.Entry<String, Integer> m : map.entrySet()) {
                if (m.getValue() < i ) System.out.print(" ");
                else System.out.print("#");
            }
            System.out.println();
        }
        for(Map.Entry<String, Integer> m : map.entrySet()) {
            System.out.print(m.getKey());
        }

    }
}
