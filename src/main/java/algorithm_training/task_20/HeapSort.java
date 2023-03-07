package algorithm_training.task_20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

//ссылка на задание https://contest.yandex.ru/contest/45468/problems/20/
public class HeapSort {
    private ArrayList<Integer> heapList = new ArrayList<>();

    public void siftUp(int n) {
        heapList.add(n);
        int pos = heapList.size() - 1;
        while (pos > 0 && heapList.get(pos) < heapList.get((pos - 1) / 2)) {
            Collections.swap(heapList, pos, (pos - 1) / 2);
            pos = (pos - 1) / 2;
        }
    }

    public int siftDown() {
        int n = heapList.get(0);
        heapList.set(0, heapList.get(heapList.size() - 1));
        int pos = 0;

        int leftChildPos = 1;
        int rightChildPos = 2;

        while (rightChildPos < heapList.size()){
            var minSonIndex = pos * 2 + 2;
            if (heapList.get(leftChildPos) < heapList.get(rightChildPos)) {
                minSonIndex--;
            }
            if (heapList.get(pos) > heapList.get(minSonIndex)) {
                Collections.swap(heapList, pos, minSonIndex);
                pos = minSonIndex;
            }
            else break;
            leftChildPos = pos * 2 + 1;
            rightChildPos = pos * 2 + 2;
        }
        heapList.remove(heapList.size() - 1);
        return n;
    }

    public String sort(String[] list){
        for (String num : list) siftUp(Integer.parseInt(num));
        StringBuilder sortHeap = new StringBuilder();
        while(!heapList.isEmpty()){
            sortHeap.append(siftDown()).append(" ");
        }
        return sortHeap.toString();
    }

    public static void main(String[] args) throws IOException {
        HeapSort heap = new HeapSort();
        BufferedReader br = new BufferedReader(new FileReader("src\\main\\java\\algorithm_training\\task_20\\input.txt"));
        var count = Integer.parseInt(br.readLine());
        String [] mas = br.readLine().split(" ");
        System.out.println(heap.sort(mas));
    }
}
