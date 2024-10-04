package LinkedList;

public class EmployeeDoubleNode {
    private Employee employee;
    private EmployeeDoubleNode next;
    private EmployeeDoubleNode previous;

    public EmployeeDoubleNode getPrevious() {
        return previous;
    }

    public void setPrevious(EmployeeDoubleNode previous) {
        this.previous = previous;
    }

    public EmployeeDoubleNode(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeDoubleNode getNext() {
        return next;
    }

    public void setNext(EmployeeDoubleNode next) {
        this.next = next;
    }

    public String toString() {
        return employee.toString();
    }
}
