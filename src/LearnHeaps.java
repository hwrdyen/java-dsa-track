import Heaps.Heap;

import java.util.PriorityQueue;

public class LearnHeaps {
    public static void heapsExample() {
        Heap heap = new Heap(10);

        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        heap.printHeap();

        // delete()
//        heap.delete(1); // delete 75
//        heap.printHeap();

//        heap.delete(5); // delete 40
//        heap.printHeap();

//        heap.delete(0); // delete 80
//        heap.printHeap();

        // peek()
        System.out.println(heap.peek());
    }

    public static void priorityQueueExample() {
        // Not like queue (FIFO) anymore, it's return the value that has the highest priority
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(25);
        pq.add(-22);
        pq.add(1343);
        pq.add(54);
        pq.add(0);
        pq.add(-3492);
        pq.add(429);

//        System.out.println(pq.peek());

        pq.remove(); // remove -3492s
//        System.out.println(pq.peek());

        pq.poll(); // poll() and remove() are the same thing; remove -22
        System.out.println(pq.peek());

        System.out.println(pq.remove(54)); // return TRUE: successfully remove it; FALSE: can't find the item

        pq.add(-1);
        System.out.println(pq.peek());
    }

    public static void heapSortExample() {
        Heap heap = new Heap(10);

        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        heap.printHeap();

        System.out.println(" ---- After HeapSort ---- ");
        heap.sort();
        heap.printHeap();
    }
}
