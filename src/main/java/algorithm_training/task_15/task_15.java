package algorithm_training.task_15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Stack;

//ссылка на задание https://contest.yandex.ru/contest/45468/problems/15/?success=83736662#30404/2023_01_18/m3PAau25IW
public class task_15 {
    private static class City {
        Integer index;
        Integer cost;

        City(Integer index, Integer cost){
            this.index = index;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\java\\algorithm_training\\task_15\\input.txt"))) {
            var number = Integer.parseInt(br.readLine());
            var mas = br.readLine().split(" ");

            Stack<City> stack = new Stack<>();

            int[] paths = new int[number];
            Arrays.fill(paths, -1);

            for (int i = 0; i < number; i ++) {
                while (!stack.isEmpty() && stack.peek().cost > Integer.parseInt(mas[i])) {
                    var n = stack.pop();
                    paths[n.index] = i;
                }
                stack.push(new City(i, Integer.parseInt(mas[i])));
            }
            System.out.println(Arrays.toString(paths).replaceAll("\\[|\\]|," , ""));
        }
    }
}
