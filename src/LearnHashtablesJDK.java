import LinkedList.Employee;

import java.util.*;

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

    public static void bucketSortExample() {
        int[] intArray = { 54, 46, 83, 66, 95, 92, 43 };

        bucketSort(intArray);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }

    }

    public static void bucketSort(int[] input) {
        List<Integer>[] buckets = new List[10]; // beauty of using List is you can easily change between ArrayList, LinkedList, or other list type

        // create buckets
        for (int i = 0; i < buckets.length; i++) {
            // using array list as the bucket
            buckets[i] = new ArrayList<Integer>();

            // using linked list as the bucket
//            buckets[i] = new LinkedList<Integer>();
        }

        // scatter the values into the buckets by hashing them
        for (int i = 0; i < input.length; i++) {
            buckets[hash(input[i])].add(input[i]); // Example: for 54, hash(input[i]) = 5; so we'll put 54 inside buckets[5]
        }

        // sort every bucket
        for (List bucket: buckets) {
            Collections.sort(bucket); // Collections.sort() is default to be merge-sort
        }

        // copy the values in the buckets back into the original array
        int j = 0;
        for (int i = 0; i < buckets.length; i++) { // traverse the bucket array
            for (int value: buckets[i]) { // traverse the input array list
                input[j++] = value;
            }
        }
    }

    private static int hash(int value) { // was used in radix sort
        return value / (int) 10 % 10; // Example: (54/10 = 5) % 10 = 5
    }

    public static void hashmapChallengeOne() {
        System.out.println(" --- Challenge One --- ");
        int[] nums = new int[10];
        int[] numsToAdd = { 59382, 43, 6894, 500, 99, -58 };
        for (int i = 0; i < numsToAdd.length; i++) {
            nums[hashChallengeOne(numsToAdd[i])] = numsToAdd[i];
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int hashChallengeOne(int value) {
        return Math.abs(value % 10);
    }

    public static void hashmapChallengeTwo() {
        System.out.println(" --- Challenge Two --- ");
        // Challenge Two
        // Remove duplicate items from a linked list
        // Your solution must use the JDK's LinkedList class
        // Your solution must use a HashMap
        // Use the starter project in the resources section

        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Mike", "Wilson", 45));
        employees.add(new Employee("Mary", "Smith", 5555));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Bill", "End", 3948));
        employees.add(new Employee("Jane", "Jones", 123));

        employees.forEach(e -> System.out.println(e));

        HashMap<Integer, Employee> employeeTable = new HashMap<>();
        ListIterator<Employee> iterator = employees.listIterator();
        List<Employee> remove = new ArrayList<>();

        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employeeTable.containsKey(employee.getId())) {
                remove.add(employee);
            } else {
                employeeTable.put(employee.getId(), employee);
            }
        }

        for (Employee employee : remove) {
            employees.remove(employee);
        }

        System.out.println("----------------------------------");

        employees.forEach(e -> System.out.println(e));
    }
}
