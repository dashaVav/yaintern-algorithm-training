package algorithm_training.task_19;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

//ссылка на задание https://contest.yandex.ru/contest/45468/problems/19/
public class Heap {
    private ArrayList<Integer> heapList = new ArrayList<>();
    public void insert(int n){
        heapList.add(n);
        siftUp();
    }

    public void siftUp() {
        int pos = heapList.size() - 1;
        while (pos > 0 && heapList.get(pos) > heapList.get((pos - 1) / 2)) {
            Collections.swap(heapList, pos, (pos - 1) / 2);
            pos = (pos - 1) / 2;
        }
    }

    public int extract() {
        int n = heapList.get(0);
        siftDown();
        return n;
    }
    public void siftDown() {
        heapList.set(0, heapList.get(heapList.size() - 1));
        int pos = 0;

        int leftChildPos = 1;
        int rightChildPos = 2;

        while (rightChildPos < heapList.size()){
            var minSonIndex = pos * 2 + 2;
            if (heapList.get(leftChildPos) > heapList.get(rightChildPos)) {
                minSonIndex--;
            }
            if (heapList.get(pos) < heapList.get(minSonIndex)) {
                Collections.swap(heapList, pos, minSonIndex);
                pos = minSonIndex;
            }
            else break;
            leftChildPos = pos * 2 + 1;
            rightChildPos = pos * 2 + 2;
        }
        heapList.remove(heapList.size() - 1);
    }

    public static void main(String[] args) throws IOException {
        Heap heap = new Heap();
        BufferedReader br = new BufferedReader(new FileReader("src\\main\\java\\algorithm_training\\task_19\\input.txt"));
        var count = Integer.parseInt(br.readLine());
        String s;
        while ((s = br.readLine()) != null) {
            String[] command = s.split(" ");
            if (command[0].equals("0")) heap.insert(Integer.parseInt(command[1]));
            else {
                System.out.println(heap.extract());
            }
        }
    }
}
