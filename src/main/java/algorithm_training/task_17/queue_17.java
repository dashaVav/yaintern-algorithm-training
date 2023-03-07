package algorithm_training.task_17;

import java.io.*;

import static java.lang.Math.pow;

//ссылка на задание https://contest.yandex.ru/contest/45468/problems/17/
public class queue_17 {
    private static class Node {
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
    }

    private int size = 0;
    private Node head;
    private Node tail;

    public boolean isEmpty(){
        return head == null;
    }
    public void push(int n) {
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

    public void pop() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        size --;
    }

    public int front() {
        return head.num;
    }

    public int getSize(){
        return size;
    }

    public static void main(String[] args) throws IOException {
        queue_17 queue1 = new queue_17();
        queue_17 queue2 = new queue_17();

        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\java\\algorithm_training\\task_17\\input.txt"))) {
            String[] card1 = br.readLine().split(" ");
            String[] card2 = br.readLine().split(" ");
            for (int i = 0; i < 5; i++) {
                queue1.push(Integer.parseInt(card1[i]));
                queue2.push(Integer.parseInt(card2[i]));
            }
        }

        while (queue1.getSize() != 0 && queue2.getSize() != 0){
            if (queue1.front() == 0 && queue2.front() == 9){
                queue1.push(queue1.front());
                queue1.push(queue2.front());
            }
            else if (queue2.front() == 0 && queue1.front() == 9){
                queue2.push(queue1.front());
                queue2.push(queue2.front());
            }
            else if (queue1.front() > queue2.front()) {
                queue1.push(queue1.front());
                queue1.push(queue2.front());
            }
            else {
                queue2.push(queue1.front());
                queue2.push(queue2.front());
            }
            queue1.pop();
            queue2.pop();
            count ++;
            if (count == pow(10, 6)) {
                System.out.println("botva");
                return;
            }
        }
        System.out.println(queue1.getSize() == 0 ? "second " + count : "first " + count);

    }

}
