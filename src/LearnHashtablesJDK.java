import LinkedList.Employee;

import java.util.HashMap;
import java.util.Map;

public class LearnHashtablesJDK {
    // if we use HashTable class, then every element needs to be non-null
    public static void hashMapJDKExample() {
        System.out.println("--- Hashtable JDK ---");

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd =  new Employee("Bill", "End", 78);

        Map<String, Employee> hashMap = new HashMap<String, Employee>();
        hashMap.put("Jones", janeJones);
        hashMap.put("Doe", johnDoe);
        hashMap.put("Smith", marySmith);
//        hashMap.put("Doe", mikeWilson); // this is going to replace johnDoe cause they are using the same key
//        hashMap.putIfAbsent("Doe", mikeWilson); // cant replace already existed key-value pair

        // method 1 to print:
//        Iterator<Employee> iterator = hashMap.values().iterator();
//        while(iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        // method 2 to print:
        hashMap.forEach((k, v) -> System.out.println("Key = " + k + ", Employee = " + v));

        // containsKey()
//        System.out.println(hashMap.containsKey("Doe"));
        // containsValues()
//        System.out.println(hashMap.containsValue(janeJones));

        // getOrDefault()
//        System.out.println(hashMap.getOrDefault("someone", mikeWilson)); // get mikeWilson if the key is invalid

        // remove()
//        System.out.println(hashMap.remove("Jones"));
    }
}
