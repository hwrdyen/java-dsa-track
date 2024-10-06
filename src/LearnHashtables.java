import Hashtables.LinearProbingHashtable;
import Hashtables.SimpleHashtable;
import LinkedList.Employee;

public class LearnHashtables {

    public static void simpleHashtableExample() {
        System.out.println("--- Simple Hashtable ---");

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd =  new Employee("Bill", "End", 78);

        SimpleHashtable ht = new SimpleHashtable();
        ht.put("Jones", janeJones);
        ht.put("Doe", johnDoe);
        ht.put("Wilson", mikeWilson);
//        ht.put("Smith", marySmith); // causes collision
//        ht.printHashtable();

        System.out.println("Retrieve key Wilson: " + ht.get("Wilson"));
    }

    public static void linearProbingHashtableExample() {
        System.out.println("--- Linear Probing Hashtable ---");

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd =  new Employee("Bill", "End", 78);

        LinearProbingHashtable ht = new LinearProbingHashtable();
        ht.put("Jones", janeJones);
        ht.put("Doe", johnDoe);
        ht.put("Wilson", mikeWilson);
        ht.put("Smith", marySmith); // causes collision
//        ht.printHashtable();

        System.out.println("Retrieve key Wilson: " + ht.get("Wilson"));
        System.out.println("Retrieve key Smith: " + ht.get("Smith"));

        ht.remove("Wilson");
        ht.remove("Jones");
        ht.printHashtable();
        System.out.println("Retrieve key Smith: " + ht.get("Smith")); // without editing remove() function, marySmith can't be find because Wilson and Jones are removed so the while-loop will hit the null value first when we get the "Smith" key and end the while-loop directly

    }

}
