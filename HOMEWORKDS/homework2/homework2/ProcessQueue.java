package midterm.homework2;

import java.util.ArrayList;

public class ProcessQueue {
    private ArrayList<Process> heap;

    public ProcessQueue() {
        heap = new ArrayList<>();
    }

    public void addProcess(Process process) {
        heap.add(process);
        heapifyUp(heap.size() - 1);
    }

    public Process runNextProcess() {
        if (heap.isEmpty()) {
            return null;
        }
        Process nextProcess = heap.get(0);
        Process lastProcess = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastProcess);
            heapifyDown(0);
        }
        return nextProcess;
    }

    public Process peekNextProcess() {
        return heap.isEmpty() ? null : heap.get(0);
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        int leftChild;
        int rightChild;
        int smallest;

        while ((leftChild = 2 * index + 1) < heap.size()) {
            smallest = leftChild;
            rightChild = leftChild + 1;

            if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(leftChild)) < 0) {
                smallest = rightChild;
            }

            if (heap.get(index).compareTo(heap.get(smallest)) <= 0) {
                break;
            }

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        Process temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}