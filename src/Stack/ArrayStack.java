package Stack;

import LinkedList.Employee;

import java.util.EmptyStackException;

public class ArrayStack {
    private Employee[] stack;
    public int top; // top contains the index of the next available position in the array (not the top item)

    public ArrayStack(int capacity) {
        stack = new Employee[capacity];
    }

    public void push(Employee employee) {
        if (top == stack.length) {
            // if it's full, then need to resize the backing array (double the capacity)
            Employee[] newArray = new Employee[2 * stack.length];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
        }

        stack[top++] = employee;
    }

    public Employee pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        Employee employee = stack[--top]; // top is at five, then the employee at the top is at index 4
        stack[top] = null;

        return employee;
    }

    public Employee peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack[top - 1]; // don't use [--top] because it changes the value of top
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void printStack() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
