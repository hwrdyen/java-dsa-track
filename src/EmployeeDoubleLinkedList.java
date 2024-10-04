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

    public boolean addBefore (Employee newEmployee, Employee exisitngEmployee) {
        // Return true if you were able to successfully add the employee into the list before the existing employee
        // Return false if the existing employee doesn't exist in the list

        if (isEmpty()) {
            return false;
        }

        // find the existing employee
        EmployeeDoubleNode current = head;
        while (current != null && !current.getEmployee().equals(exisitngEmployee)) {
            current = current.getNext();
        }

        if (current == null) {
            return false; // the existing employee doesn't exist
        }

        EmployeeDoubleNode newNode = new EmployeeDoubleNode(newEmployee);
        newNode.setPrevious(current.getPrevious());
        newNode.setNext(current);
        current.setPrevious(newNode);
        if (head == current) {
            head = newNode;
        } else {
            newNode.getPrevious().setNext(newNode);
        }

        size++;
        return true;
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

