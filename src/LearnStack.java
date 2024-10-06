import LinkedList.Employee;
import Stack.ArrayStack;
import Stack.LinkedStack;

import java.util.LinkedList;

public class LearnStack {
    public static void arrayStackExample() {
        System.out.println("--- Stack (Array) ---");

        ArrayStack stack = new ArrayStack(10);
        stack.push(new Employee("Jane", "Jones", 123));
        stack.push(new Employee("John", "Doe", 4567));
        stack.push(new Employee("Mary", "Smith", 22));
        stack.push(new Employee("Mike", "Wilson", 3245));
        stack.push(new Employee("Bill", "End", 78));

        stack.printStack();
//        System.out.println("peek = " + stack.peek());

        System.out.println("popped = " + stack.pop());
        System.out.println("peek = " + stack.peek());
    }

    public static void linkedlistStackExample() {
        System.out.println("--- Stack (Linked List) ---");

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        LinkedStack stack = new LinkedStack();
        stack.push(janeJones);
        stack.push(johnDoe);
        stack.push(marySmith);
        stack.push(mikeWilson);
        stack.push(billEnd);

//        stack.printStack();
//        System.out.println("peek = " + stack.peek());
        stack.printStack();

        System.out.println("popped = " + stack.pop());
        System.out.println("peek = " + stack.peek());
    }

    public static void stackChallengeOne() {
        // CHALLENGE #1
        // Using a stack, determine whether a string is a palindrome
        // Strings may contain punctuation and spaces. They should be ignored. Case should be ignored
        // Examples:
        // "I did, did I?" is a palindrome
        // "Racecar" is a palindrome
        // "hello" is not a palindrome
        // Use the started project in the resources section
        System.out.println("--- Challenge One ---");

        // should return true
        System.out.println(checkForPalindromeStack("abccba"));
        // should return true
        System.out.println(checkForPalindromeStack("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindromeStack("I did, did I?"));
        // should return false
        System.out.println(checkForPalindromeStack("hello"));
        // should return true
        System.out.println(checkForPalindromeStack("Don't nod"));
    }
    public static boolean checkForPalindromeStack(String string) {
        LinkedList<Character> stack = new LinkedList<Character>();
//        Stack<Character> stack = new Stack<Character>();
        StringBuilder stringNoPunctionation = new StringBuilder(string.length());
        String lowerCase = string.toLowerCase();

        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            if (c >= 'a' && c <= 'z') {
                stringNoPunctionation.append(c);
                stack.push(c);
            }
        }
//        System.out.println(stringNoPunctionation);

        // reversedString
        StringBuilder reversedString = new StringBuilder(stack.size());
        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }

        // two strings compare if they are equal (normal and reversedString)
        return reversedString.toString().equals(stringNoPunctionation.toString());
    }
}
