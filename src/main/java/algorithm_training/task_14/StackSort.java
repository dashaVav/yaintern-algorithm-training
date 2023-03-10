package algorithm_training.task_14;

import java.io.BufferedReader;

import java.io.FileReader;
import java.util.*;

//ссылка на задание https://contest.yandex.ru/contest/45468/problems/14/
public class StackSort {
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\java\\algorithm_training\\task_14\\input.txt"))) {
            var number = br.readLine();
            var mas = br.readLine().split(" ");
            Stack<Integer> stack = new Stack<>();

            var count = 1;
            for (String n : mas) {
                if (count != Integer.parseInt(n)) {
                    stack.push(Integer.parseInt(n));
                }
                else {
                    ++count;
                    while (!stack.isEmpty() && stack.peek() == count) {
                        stack.pop();
                        ++count;
                    }
                }
            }
            if (stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
