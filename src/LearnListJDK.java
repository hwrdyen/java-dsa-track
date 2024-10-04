import LinkedList.Employee;
import LinkedList.EmployeeDoubleLinkedList;
import LinkedList.IntegerLinkedList;

import java.util.Iterator;
import java.util.LinkedList;
public class LearnListJDK {
    public static void JDKLinkedListExample() {
        System.out.println("--- JDK Linked List ---");

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        // addFirst()
        LinkedList<Employee> list = new LinkedList<>();
        list.addFirst(janeJones); // add item to the front
        list.addFirst(johnDoe);
        list.addFirst(marySmith);
        list.addFirst(mikeWilson);

        Iterator iter = list.iterator();
        System.out.print("HEAD -> ");
        while (iter.hasNext()) {
            System.out.print(iter.next());
            System.out.print(" <=> ");
        }
        System.out.println("null");

        // add()
        Employee billEnd = new Employee("Bill", "End", 6789);
        list.add(billEnd); // add items to the end (can also use "addLast()")
        iter = list.iterator();
        System.out.print("HEAD -> ");
        while (iter.hasNext()) {
            System.out.print(iter.next());
            System.out.print(" <=> ");
        }
        System.out.println("null");

        // removeFirst()
        list.removeFirst(); // or you can use "remove()"
        iter = list.iterator();
        System.out.print("HEAD -> ");
        while (iter.hasNext()) {
            System.out.print(iter.next());
            System.out.print(" <=> ");
        }
        System.out.println("null");

        // removeLast()
        list.removeLast();
        iter = list.iterator();
        System.out.print("HEAD -> ");
        while (iter.hasNext()) {
            System.out.print(iter.next());
            System.out.print(" <=> ");
        }
        System.out.println("null");
    }

    public static void listChallengeOne() {
        // CHALLENGE #1
        // Implement the addBefore() method for the LinkedList.EmployeeDoubleLinkedList class
        // Use the starter project in the resources section
        // Project contains all the code you need and an empty addBefore() method
        // Main method contains code that should work when you're finished

        System.out.println("--- Challenge One ---");

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        EmployeeDoubleLinkedList list = new EmployeeDoubleLinkedList();

        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);
        list.addToFront(mikeWilson);
        list.printList();

        list.addBefore(billEnd, johnDoe);
        list.printList();

        list.addBefore(new Employee("Someone", "Else", 1111), mikeWilson);
        list.printList();
    }

    public static void listChallengeTwo() {
        // CHALLENGE #1
        // Use the starter project in the resources section
        // Implement a method in the LinkedList.IntegerLinkedList class that inserts a value in sorted order
        // Lower values should appear first in the list (be closer to the head)
        // If we insert 4, 2, 1, 5, list should look like HEAD --> 1 --> 2 --> 4 --> 5 --> null
        // LinkedList.IntegerLinkedList is a singly-linked list
        // Project contains all the code you need and an empty insertSorted() method
        // Main method contains code that should work when you're finished

        System.out.println("--- Challenge Two ---");
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;

        IntegerLinkedList list = new IntegerLinkedList();
        list.insertSorted(three);
        list.printList();
        list.insertSorted(two);
        list.printList();
        list.insertSorted(one);
        list.printList();
        list.insertSorted(four);
        list.printList();
    }
}
