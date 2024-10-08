public class LearnSearchAlgo {

    public static void linearSearchExample() {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        System.out.println(linearSearch(intArray, -15));
        System.out.println(linearSearch(intArray, 1));
        System.out.println(linearSearch(intArray, 8888));
        System.out.println(linearSearch(intArray, -22));
    }

    public static int linearSearch(int[] input, int value) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static void binarySearchIterativeExample() {
        int[] intArray = { -22, -15, 1, 7, 20, 35, 55 };

        System.out.println(iterativeBinarySearch(intArray, -15));
        System.out.println(iterativeBinarySearch(intArray, 35));
        System.out.println(iterativeBinarySearch(intArray, 8888));
        System.out.println(iterativeBinarySearch(intArray, 1));
    }

    public static int iterativeBinarySearch(int[] input, int value) {
        int start = 0;
        int end = input.length;

        while (start < end) {
            int midpoint = (start + end) / 2;
            if (input[midpoint] == value) {
                return midpoint;
            }
            else if (input[midpoint] < value) {
                start = midpoint + 1;
            }
            else {
                end = midpoint;
            }
        }

        return -1;
    }

    public static void binarySearchRecursiveExample() {
        int[] intArray = { -22, -15, 1, 7, 20, 35, 55 };

        System.out.println(recursiveBinarySearch(intArray, -15));
        System.out.println(recursiveBinarySearch(intArray, 35));
        System.out.println(recursiveBinarySearch(intArray, 8888));
        System.out.println(recursiveBinarySearch(intArray, 1));
    }

    public static int recursiveBinarySearch(int[] input, int value) {
        return recursive(input, 0, input.length, value);
    }

    public static int recursive(int[] input, int start, int end, int value) {
        if (start >= end) {
            return -1;
        }

        int midpoint = (start + end) / 2;
        if (input[midpoint] == value) {
            return midpoint;
        } else if (input[midpoint] > value) { // check left-part
            return recursive(input, start, midpoint, value);
        } else { // check right-part
            return recursive(input, (midpoint + 1), end, value);
        }

    }
}
