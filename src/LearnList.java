import java.util.*;

public class LearnList {

    public static void arrayListExample() {
        System.out.println("--- ArrayList ---");
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("Jane", "Jones", 123));
        employeeList.add(new Employee("John", "Doe", 4567));
        employeeList.add(new Employee("Mary", "Smith", 22));
        employeeList.add(new Employee("Mike", "Wilson", 3245));

//        employeeList.forEach(employee -> System.out.println(employee));
//
//        System.out.println(employeeList.get(1));
//
//        System.out.println(employeeList.isEmpty());

        employeeList.set(1, new Employee("John", "Adams", 4568)); // replace element inside ArrayList
//        employeeList.forEach(employee -> System.out.println(employee));

//        System.out.println(employeeList.size());

        employeeList.add(3, new Employee("John", "Doe", 4567)); // O(n) -- as the worst case is all the elements will be shifted
//        employeeList.forEach(employee -> System.out.println(employee));

        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
//        for (Employee employee: employeeArray) {
//            System.out.println(employee);
//        }

        System.out.println(employeeList.contains(new Employee("Mary", "Smith", 22))); // false before overwrite equals() method, after overwrite returns true, equals() is looking at the value in the fields
        System.out.println(employeeList.indexOf(new Employee("John", "Doe", 4567)));

        employeeList.remove(2);
        employeeList.forEach(employee -> System.out.println(employee));
    }

    public static void vectorExample() {
        System.out.println("--- Vector ---");
        List<Employee> employeeList = new Vector<>();

        employeeList.add(new Employee("Jane", "Jones", 123));
        employeeList.add(new Employee("John", "Doe", 4567));
        employeeList.add(new Employee("Mary", "Smith", 22));
        employeeList.add(new Employee("Mike", "Wilson", 3245));

//        employeeList.forEach(employee -> System.out.println(employee));
//
//        System.out.println(employeeList.get(1));
//
//        System.out.println(employeeList.isEmpty());

        employeeList.set(1, new Employee("John", "Adams", 4568)); // replace element inside ArrayList
//        employeeList.forEach(employee -> System.out.println(employee));

//        System.out.println(employeeList.size());

        employeeList.add(3, new Employee("John", "Doe", 4567)); // O(n) -- as the worst case is all the elements will be shifted
//        employeeList.forEach(employee -> System.out.println(employee));

        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
//        for (Employee employee: employeeArray) {
//            System.out.println(employee);
//        }

        System.out.println(employeeList.contains(new Employee("Mary", "Smith", 22))); // false before overwrite equals() method, after overwrite returns true, equals() is looking at the value in the fields
        System.out.println(employeeList.indexOf(new Employee("John", "Doe", 4567)));

        employeeList.remove(2);
        employeeList.forEach(employee -> System.out.println(employee));
    }

    public static void singleLinkedListExample() {
        System.out.println("--- Single Linked List ---");

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        EmployeeLinkedList list = new EmployeeLinkedList();

        System.out.println(list.isEmpty());

        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);
        list.addToFront(mikeWilson);

        System.out.println(list.isEmpty());
        System.out.println(list.getSize());
        list.printList();

        list.removeFromFront();
        System.out.println(list.getSize());
        list.printList();
    }

    public static void doubleLinkedListExample() {
        System.out.println("--- Double Linked List ---");

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        EmployeeDoubleLinkedList list = new EmployeeDoubleLinkedList();

        System.out.println(list.isEmpty());

        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);
        list.addToFront(mikeWilson);

        System.out.println(list.isEmpty());
        System.out.println(list.getSize());
        list.printList();


        Employee billEnd = new Employee("Bill", "End", 78);
        list.addToEnd(billEnd);
        System.out.println(list.getSize());
        list.printList();


        list.removeFromFront();
        System.out.println(list.getSize());
        list.printList();

        list.removeFromEnd();
        System.out.println(list.getSize());
        list.printList();
    }
}
