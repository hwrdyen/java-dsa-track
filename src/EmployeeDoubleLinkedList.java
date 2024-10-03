public class EmployeeDoubleLinkedList {
    private EmployeeDoubleNode head;
    private EmployeeDoubleNode tail;
    private int size;

    public void addToFront(Employee employee) {
        EmployeeDoubleNode node = new EmployeeDoubleNode(employee);

        if (head == null) {
            tail = node;
        } else {
            head.setPrevious(node);
            node.setNext(head);
        }

        head = node;
        size++;
    }

    public void addToEnd(Employee employee) {
        EmployeeDoubleNode node = new EmployeeDoubleNode(employee);

        if (tail == null) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
        }

        tail = node;
        size++;
    }

    public EmployeeDoubleNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }
        EmployeeDoubleNode removedNode = head;

        if (head.getNext() == null) {
            tail = null;
        } else {
            head.getNext().setPrevious(null);
        }

        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public EmployeeDoubleNode removeFromEnd() {
        if (isEmpty()) {
            return null;
        }
        EmployeeDoubleNode removedNode = tail;

        if (tail.getPrevious() == null) {
            head = null;
        } else {
            tail.getPrevious().setNext(null);
        }

        tail = tail.getPrevious();
        size--;
        removedNode.setPrevious(null);
        return removedNode;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        EmployeeDoubleNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            if (current.getNext() == null) {
                System.out.print(" -> ");
            } else {
                System.out.print(" <=> ");
            }

            current = current.getNext();
        }
        System.out.println("null");
    }
}

