package algorithm_training.task_13;

import java.util.Scanner;
import java.util.Stack;

//ссылка на задание https://contest.yandex.ru/contest/45468/problems/13/
public class PolishNotation {
    public static void main(String[] args){
        String[] str = new Scanner(System.in).nextLine().split(" ");
        Stack<Integer> stack = new Stack<>();

        for (String symbol : str) {
            switch (symbol) {
                    case "+" -> stack.push(stack.pop() + stack.pop());
                    case "-" -> {
                        var a = stack.pop();
                        stack.push(stack.pop() - a);
                    }
                    case "*" -> stack.push(stack.pop() * stack.pop());
                    default -> stack.push(Integer.parseInt(symbol));
            }
        }
        System.out.println(stack.pop());
    }
}
