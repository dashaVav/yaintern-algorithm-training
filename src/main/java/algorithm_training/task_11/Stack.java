package algorithm_training.task_11;

import java.io.*;

//ссылка на задание https://contest.yandex.ru/contest/45468/problems/11/
public class Stack {
    public static class Node {
        int num;
        Node prev;
        Node next;
        Node(int n) {
            num = n;
        }
        Node(int n, Node nodePrev){
            num = n;
            prev = nodePrev;
        }
    }

    private int size = 0;
    private Node tail;

    public boolean isEmpty(){
        return size == 0;
    }

    public void push(int n) {
        if (tail == null) {
            tail = new Node(n);
            size ++;
            return;
        }
        var node = new Node(n, tail);
        tail.next = node;
        tail = node;
        size ++;
    }

    public int pop() {
        var n = back();
        tail = tail.prev;
        if (tail != null)  tail.next =  null;
        size --;
        return n;
    }

    public int getSize(){
        return size;
    }

    public int back(){
        return tail.num;
    }

    public void clear() {
        tail = null;
        size = 0;
    }

    public static void main(String[] args){
        String s;
        Stack stack = new Stack();
        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\java\\algorithm_training\\task_11\\input.txt"))) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\main\\java\\algorithm_training\\task_11\\output.txt"))) {
                while ((s = br.readLine()) != null) {
                    String[] command = s.split(" ");
                    switch (command[0]) {
                        case "push" -> {
                            stack.push(Integer.parseInt(command[1]));
                            bw.write("ok\n");
                        }
                        case "pop" -> {
                            if (stack.isEmpty()) {
                                bw.write("error\n");
                            } else {
                                bw.write(stack.pop() + "\n");
                            }
                        }
                        case "back" -> {
                            if (stack.isEmpty()) {
                                bw.write("error\n");
                            } else {
                                bw.write(stack.back() + "\n");
                            }
                        }
                        case "size" -> bw.write(stack.getSize() + "\n");
                        case "clear" -> {
                            stack.clear();
                            bw.write("ok\n");
                        }
                        case "exit" -> {
                            bw.write("bye");
                            return;
                        }
                    }
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
