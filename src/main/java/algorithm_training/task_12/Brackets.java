package algorithm_training.task_12;

import java.util.Scanner;
import java.util.Stack;

//ссылка на задание https://contest.yandex.ru/contest/45468/problems/12/
public class Brackets {
    public static void main(String[] args){
        char[] str = new Scanner(System.in).nextLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char symbol : str) {
            switch (symbol) {
                case '{', '(', '[' -> stack.push(symbol);
                case '}' -> {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        System.out.println("no");
                        return;
                    }
                }
                case ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        System.out.println("no");
                        return;
                    }
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        System.out.println("no");
                        return;
                    }
                }

            }
        }
        if (stack.isEmpty()) System.out.println("yes");
        else System.out.println("no");

    }

}
