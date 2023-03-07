package algorithm_training.task_18;

import java.io.*;

//ссылка на задание https://contest.yandex.ru/contest/45468/problems/18/?success=83580230#175943/2016_11_22/pJwxx9Ejoh
public class deque {
    public static class Node {
        int num;
        Node prev;
        Node next;
        Node(int n) {
            num = n;
        }
        Node(int n, Node node){
            num = n;
            prev = node;
        }

        Node(int n, Node node, Node nodeNext){
            num = n;
            prev = node;
            next = nodeNext;
        }
    }

    private int size = 0;
    private Node head;
    private Node tail;

    public boolean isEmpty(){
        return size == 0;
    }

    public void push_front(int n) {
        if (head == null) {
            var node = new Node(n);
            head = node;
            tail = node;
            size ++;
            return;
        }
        var node = new Node(n, null, head);
        head.prev = node;
        head = node;
        size ++;
    }

    public void push_back(int n) {
        if (head == null) {
            var node = new Node(n);
            head = node;
            tail = node;
            size ++;
            return;
        }
        var node = new Node(n, tail);
        tail.next = node;
        tail = node;
        size ++;
    }

    public int front() {
        return head.num;
    }

    public int back() {
        return tail.num;
    }

    public void pop_front() {
        head = head.next;
        if (head != null) head.prev = null;
        size --;
    }

    public void pop_back(){
        tail = tail.prev;
        if (tail != null)  tail.next= null;
        size --;
    }
    public int getSize(){
        return size;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public static void main(String[] args){
        String s;
        deque deque = new deque();
        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\java\\algorithm_training\\task_18\\input.txt"))) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\main\\java\\algorithm_training\\task_18\\output.txt"))) {
                while ((s = br.readLine()) != null) {
                    String[] command = s.split(" ");
                    switch (command[0]) {
                        case "push_front" -> {
                            deque.push_front(Integer.parseInt(command[1]));
                            bw.write("ok\n");
                        }
                        case "push_back" -> {
                            deque.push_back(Integer.parseInt(command[1]));
                            bw.write("ok\n");
                        }
                        case "pop_front" -> {
                            if (deque.isEmpty()) {
                                bw.write("error\n");
                            } else {
                                bw.write(deque.front() + "\n");
                                deque.pop_front();
                            }
                        }
                        case "pop_back" -> {
                            if (deque.isEmpty()) {
                                bw.write("error\n");
                            } else {
                                bw.write(deque.back() + "\n");
                                deque.pop_back();
                            }
                        }
                        case "front" -> {
                            if (deque.isEmpty()) {
                                bw.write("error\n");
                            } else {
                                bw.write(deque.front() + "\n");
                            }
                        }
                        case "back" -> {
                            if (deque.isEmpty()) {
                                bw.write("error\n");
                            } else {
                                bw.write(deque.back() + "\n");
                            }
                        }
                        case "size" -> bw.write(deque.getSize() + "\n");
                        case "clear" -> {
                            deque.clear();
                            bw.write("ok\n");
                        }
                        case "exit" -> {
                            bw.write("bye");
                            return;
                        }
                    }
                }
                System.out.println();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
