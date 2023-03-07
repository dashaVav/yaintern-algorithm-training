package algorithmt_raining.task_16;

import java.io.*;

//ссылка на задание https://contest.yandex.ru/contest/45468/problems/16/
public class queue {

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
        if (head == null) return true;
        return false;
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

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public static void main(String[] args) throws IOException {
        String s;
        queue queue = new queue();
        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\java\\algorithmt_raining\\task_16\\input.txt"))) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\main\\java\\algorithmt_raining\\task_16\\output.txt"))) {
                while ((s = br.readLine()) != null) {
                    String[] command = s.split(" ");
                    switch (command[0]){
                        case "push":
                            int n = Integer.parseInt(command[1]);
                            queue.push(n);
                            bw.write("ok\n");
                            break;
                        case "pop":
                            if (queue.isEmpty()){
                                bw.write("error\n");
                            }
                            else {
                                bw.write(queue.front() + "\n");
                                queue.pop();
                            }
                            break;
                        case "front":
                            if (queue.isEmpty()){
                                bw.write("error\n");
                            }
                            else {
                                bw.write(queue.front() + "\n");
                            }
                            break;
                        case "size":
                            bw.write(queue.getSize() + "\n");
                            break;
                        case "clear":
                            queue.clear();
                            bw.write("ok\n");
                            break;
                        case "exit":
                            bw.write("bye");
                            return;
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
