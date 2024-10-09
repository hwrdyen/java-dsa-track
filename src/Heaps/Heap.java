package Heaps;

public class Heap {
    private int[] heap;
    private int size;

    public Heap(int capacity) {
        heap = new int[capacity];
    }

    public void insert(int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Heap is full");
        }

        heap[size] = value; // heap[size++} == heap[size] = value; size++;

        fixHeapAbove(size);
        size++;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        return heap[0];
    }

    public int delete(int index) { // for Heap delete() in general, you don't want to take any thing else besides Root off the heap; That's why heap.delete() method in JDK actaully doesn't take into any value as input
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        int parent = getParent(index);
        int deletedValue = heap[index];

        heap[index] = heap[size - 1];

        if (index == 0 || heap[index] < heap[parent]) { // heap[index] < heap[parent] ==> everything above meets the Heap Property, so need to fixHeapBelow
            fixHeapBelow(index, size-1);
        } else {
            fixHeapAbove(index);
        }

        size--;

        return deletedValue;
    }

    public void sort() {
        int lastHeapIndex = size - 1;
        for (int i = 0; i < lastHeapIndex; i++) {
            int tmp = heap[0];
            heap[0] = heap[lastHeapIndex - i];
            heap[lastHeapIndex - i] = tmp;

            fixHeapBelow(0, lastHeapIndex-i-1); // lastHeapIndex-i-1: (-1) ==> need to exclude where we put the root
        }
    }

    private void fixHeapAbove(int index) {
        int newValue = heap[index];
        // if index == 0, value is at the root node
        while (index > 0 && newValue > heap[getParent(index)]) { // shifting any parents that are less than the newValue down
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }

        heap[index] = newValue;
    }

    private void fixHeapBelow(int index, int lastHeapIndex) {
        int childToSwap;

        while (index <= lastHeapIndex) {
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);

            // why are we only checking leftChild ==> because Heap needs to be a complete tree, so you need to have a left child before you have a right child
            if (leftChild <= lastHeapIndex) { // have children --> we have heapifying need to do
                if (rightChild > lastHeapIndex) {
                    // have a left child, but no right child
                    childToSwap = leftChild;
                } else {
                    // have both left child and right child
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }

                if (heap[index] < heap[childToSwap]) { // only need to swap with Child that is larger
                    int tmp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = tmp;
                } else {
                    break;
                }

                index = childToSwap;
            } else { // if that element in that position doesn't have any children ==> done
                break;
            }

        }
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + ", ");
        }
        System.out.println();
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public int getParent(int index) {
        return (index - 1) / 2; // don't need floor, because function expect to return integer, so it will be rounded down automatically
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getChild(int index, boolean left) { // return index
        return 2 * index + (left ? 1 : 2);
    }
}
