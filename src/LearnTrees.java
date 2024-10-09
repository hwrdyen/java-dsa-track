import BinarySearchTrees.Tree;

import java.util.TreeMap;
import java.util.TreeSet;

public class LearnTrees {
    public static void binarySearchTreeExample() {
        System.out.println(" --- Binary Search Tree ---");
        Tree intTree = new Tree();
        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);
        intTree.insert(17);

        // print InOrder
        intTree.traverseInOrder();
        System.out.println();

        // get()
//        System.out.println(intTree.get(27));
//        System.out.println(intTree.get(17));
//        System.out.println(intTree.get(8888));

//        // min()
//        System.out.println("Min value = " + intTree.min());
//        // max()
//        System.out.println("Max value = " + intTree.max());

        // delete()
        intTree.delete(25);
        intTree.traverseInOrder();
        System.out.println();
    }

    public static void treeJDKExample() {
        // TreeMap<key, value> ==> Binary Search Tree
            // put()
            // get()
            // remove()
            // replace(key, value)
        System.out.println(" --- TreeMap JDK ---");
        // Creating a TreeMap with Integer keys and String values
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        // put() - Insert key-value pairs into the TreeMap
        treeMap.put(3, "Apple");
        treeMap.put(1, "Banana");
        treeMap.put(4, "Orange");
        treeMap.put(2, "Grapes");

        // Display the TreeMap (It will be sorted by keys)
        System.out.println("TreeMap: " + treeMap);

        // get() - Retrieve a value by its key
        System.out.println("Get value with key 2: " + treeMap.get(2)); // Grapes

        // remove() - Remove a key-value pair by its key
        treeMap.remove(3);
        System.out.println("After removing key 3: " + treeMap);

        // replace() - Replace the value of a key
        treeMap.replace(4, "Mango");
        System.out.println("After replacing value for key 4: " + treeMap);

        // TreeSet
        System.out.println(" --- TreeSet JDK --- ");
        // Creating a TreeSet of Integers
        TreeSet<Integer> treeSet = new TreeSet<>();

        // Adding elements using add()
        treeSet.add(10);
        treeSet.add(5);
        treeSet.add(20);
        treeSet.add(1);
        treeSet.add(15);

        // Display the TreeSet (It will be sorted in ascending order)
        System.out.println("TreeSet: " + treeSet);

        // remove() - Remove an element from the set
        treeSet.remove(10);
        System.out.println("After removing 10: " + treeSet);

        // contains() - Check if an element exists in the set
        System.out.println("Does the set contain 5? " + treeSet.contains(5)); // true

        // first() - Get the first (lowest) element
        System.out.println("First element: " + treeSet.first());

        // last() - Get the last (highest) element
        System.out.println("Last element: " + treeSet.last());
    }

    public static void binarySearchTreeChallengeOne() {
        System.out.println(" --- Challenge One --- ");
        // Challenge One
        // Add preorder traversal to our Tree implementation
        // Use the starter project in the resources area
        Tree intTree = new Tree();
        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);
        intTree.insert(17);

        intTree.traversePreOrder();
        System.out.println();
    }
}
