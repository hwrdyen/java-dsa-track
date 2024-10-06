package Queue;

import LinkedList.Employee;

import java.util.NoSuchElementException;

public class ArrayCircularQueue {
    private Employee[] queue;
    private int front;
    private int back;

    public ArrayCircularQueue(int capacity) {
        queue = new Employee[capacity];
    }

    public void add(Employee employee) {
        if (size() == queue.length - 1) {
            int numItems = size();
            Employee[] newArray = new Employee[2*queue.length];
            System.arraycopy(queue, front, newArray, 0, queue.length-front);
            System.arraycopy(queue, 0, newArray, queue.length-front, back);

            queue = newArray;

            front = 0;
            back = numItems;
        }

        queue[back] = employee;

        if (back < queue.length - 1) {
            back++;
            // == {back < queue.length - 1} ==
            // 0: jane -- front
            // 1: john
            // 2: mary
            // 3: mike
            // 4: bill
            // 5:       -- back ==> when we add Bill, size(): "4" == queue.length - 1: "4", so resized to double the queue length
        } else {
            back = 0;
            // == step 1: add jane
            // 0: jane -- front
            // 1:      -- back

            // == step 2: add john
            // 0: jane -- front
            // 1: john
            // 2:      -- back

            // == step 3: remove jane
            // 0:
            // 1: john -- front
            // 2:      -- back

            // == step 4: add mary
            // 0:
            // 1: john -- front
            // 2: mary
            // 3:      -- back

            // == sterp 5: remove john
            // 0:
            // 1:
            // 2: mary -- front
            // 3:      -- back

            // == step 5: add mike
            // 0:
            // 1:
            // 2: mary -- front
            // 3: mike
            // 4:      -- back

            // == step 6: remove mary
            // 0:
            // 1:
            // 2:
            // 3: mike -- front
            // 4:      -- back

            // == step 7: add bill (not going to resize because size() != queue.length-1)
            // 0:     -- back
            // 1:
            // 2:
            // 3: mike -- front
            // 4: bill    // back is 4 and queue.length-1 is 4, so back not ++ and becomes 0

            // == step 8: add jane
            // 0: jane
            // 1:     -- back
            // 2:
            // 3: mike -- front
            // 4: bill

            // == step 9: add john
            // 0: jane
            // 1: john
            // 2:      -- back
            // 3: mike -- front
            // 4: bill

            // == step 10: add mary (meet the size() == queue.length-1) resize queue length condition
            // 0: jane
            // 1: john
            // 2:      -- back
            // 3: mike -- front
            // 4: bill

            // ===> when resizing, then it will reorder the elements inside the queue
            // 0: mike
            // 1: bill
            // 2: jane
            // 3: john
            // 4:
            // 5:
            // ...

        }

    }

    public Employee remove() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        Employee employee = queue[front];
        queue[front] = null;
        front++;
        if (size() == 0) {
            front = 0;
            back = 0;
        }
        else if (front == queue.length) {
            front = 0;
        }

        return employee;
    }

    public Employee peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        return queue[front];
    }

    public int size() {
        if (front <= back) {
            return back - front;
        } else {
            return back - front + queue.length;
        }
    }

    public void printQueue() {
        if (front <= back) {
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        } else {
            for (int i = front; i < queue.length; i++) {
                System.out.println(queue[i]);
            }
            for (int i = 0; i < back; i++) {
                System.out.println(queue[i]);
            }
        }

    }
}
