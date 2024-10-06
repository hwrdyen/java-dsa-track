import LinkedList.Employee;
import Queue.ArrayCircularQueue;
import Queue.ArrayQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LearnQueue {

    public static void arrayQueueExample() {
        System.out.println("--- Queue (Array) ---");

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd =  new Employee("Bill", "End", 78);

        ArrayQueue queue = new ArrayQueue(3);
        // difference between Queue and Circular Queue
        queue.add(janeJones);
        queue.add(johnDoe);
        queue.remove();
        queue.add(marySmith);
        queue.remove();
        queue.add(mikeWilson);
        queue.remove();
        queue.add(billEnd);
        queue.printQueue();

//        System.out.println(queue.peek());
//        queue.printQueue();

    }

    public static void arrayCircularQueueExample() {
        System.out.println("--- Circular Queue (Array) ---"); // when repetitively add one, remove one, the queue size will not double

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd =  new Employee("Bill", "End", 78);

        ArrayCircularQueue queue = new ArrayCircularQueue(3);
        queue.add(janeJones);
        queue.add(johnDoe);
        queue.remove();
        queue.add(marySmith);
        queue.remove();
        queue.add(mikeWilson);
        queue.remove();
        queue.add(billEnd);
        queue.printQueue();


        System.out.println(queue.peek());
    }

    public static void queueChallengeOne() {
        System.out.println("--- Challenge One ---");
        // CHALLENGE ONE
        // Using a stack and a queue, determine whether a string is a palindrome
        // Strings may contain punctuation and spaces. They should be ignored. Case should be ignored
        // Examples:
        // "I did, did I?" is a palindrome
        // "Racecar" is a palindrome
        // "hello" is not a palindrome

        // should return true
        System.out.println(checkForPalindromeQueue("abccba"));
        // should return true
        System.out.println(checkForPalindromeQueue("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindromeQueue("I did, did I?"));
        // should return false
        System.out.println(checkForPalindromeQueue("hello"));
        // should return true
        System.out.println(checkForPalindromeQueue("Don't nod"));

    }

    public static boolean checkForPalindromeQueue(String string) {
        Queue<Character> queue = new LinkedList<>(); // FIFO
        Stack<Character> stack = new Stack<>(); // LIFO
        String lowerCase = string.toLowerCase();

        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            if (c >= 'a' && c <= 'z') {
                queue.add(c);
                // if we use LinkedList<Character> queue = new LinkedList<>();
                // then we use "queue.addFirst(c)"
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.remove())) {
                return false;
            }
        }

        return true;
    }
}
