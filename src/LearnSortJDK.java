public class LearnSortJDK {

    public static void sortJDKExample() {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        // this is using DualPivotQuick Sort (modified form of Quick Sort)
//        Arrays.sort(intArray);

        // faster for larger dataset
        // its doing a Merge Sort, but when its dealing with smaller partitions its sorting them using Quick Sort
//        Arrays.parallelSort(intArray);

        for (int num: intArray) {
            System.out.println(num);
        }
    }

    public static void sortChallengeOne() {
        // CHALLENGE #1
        // Modify the merge sort algorithm so that it sorts integers in DESCENDING order
        // Use the usual example array
        // You can start with the project in the resources section
        System.out.println("--- Challenge One ---");
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
        mergeSort(intArray, 0, intArray.length);
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    public static void mergeSort(int[] input, int start, int end) {
        // splitting phase remain the same
        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    public static void merge(int[] input, int start, int mid, int end) {

        if (input[mid - 1] >= input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] >= input[j] ? input[i++] : input[j++]; // need to keep '=' cause this is stable sort algo (dont want overwritten)
        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);


    }

    public static void sortChallengeTwo() {
        // CHALLENGE #2
        // Change insertion sort so that it users recursion
        // Sort the usual example array
        // You can start with the project in the resources section

        System.out.println("--- Challenge Two ---");
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        // Original Source Code:
//        insertionSortIterative(intArray);

        // Turned Iterative to Recursive:
        insertionSortRecursive(intArray, intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    // a method we can call with the number of items that we want to sort
    public static void insertionSortRecursive(int[] input, int numItems) {
        if (numItems < 2) {
            return; // if we have one item, by definition one item is sorted
        }

        insertionSortRecursive(input, numItems - 1); // by the time we return, all items have been sorted

        int newElement = input[numItems - 1];

        int i;

        for (i = numItems - 1; i > 0 && input[i - 1] > newElement; i--) {
            input[i] = input[i - 1];
        }

        input[i] = newElement;

        System.out.println("Result of call when numItems = " + numItems);
        for (i = 0; i < input.length; i++) {
            System.out.print(input[i]);
            System.out.print(", ");
        }
        System.out.println("");
        System.out.println("------------------------------");

    }

    public static void insertionSortIterative(int[] intArray) {
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length;
             firstUnsortedIndex++) {
            int newElement = intArray[firstUnsortedIndex];

            int i;

            for (i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
                intArray[i] = intArray[i - 1];
            }

            intArray[i] = newElement;
        }

    }

    public static void sortChallengeThree() {
        // CHALLENGE #3
        // Sort the following values using radix sort
        // All values are in lowercase, so don't worry about uppercasing/lowercasing the values
        // You can start with the project in the resources section

        System.out.println("--- Challenge Three ---");
        String[] stringsArray = { "bcdef", "dbaqc", "abcde", "omadd", "bbbbb"};

        // do radix sort
        // String[], so radix = 26;
        radixSortChallenge(stringsArray, 26, 5);


        for (int i = 0; i < stringsArray.length; i++) {
            System.out.println(stringsArray[i]);
        }
    }

    public static void radixSortChallenge(String[] input, int radix, int width) {
        for (int i = width - 1; i >= 0; i--) {
            radixSingleSortChallenge(input, i, radix);
        }
    }

    public static void radixSingleSortChallenge(String[] input, int position, int radix) {
        int numItems = input.length;
        int[] countArray = new int[radix];

        for (String value: input) {
            countArray[getIndex(position, value)]++;
        }

        // Adjust the count array --> so it now contains the value that have that digit or less than that digit
        for (int j = 1; j < radix; j++) {
            // we dont have to worry about number in the zero index because the number of values that have zero or one position are gonna be the number of values that have zero
            countArray[j] += countArray[j - 1];
        }

        String[] temp = new String[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getIndex(position, input[tempIndex])]] = input[tempIndex];
        }

        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }
    }

    public static int getIndex(int position, String value) {
        return value.charAt(position) - 'a';
        // this will give us position in the countArray
        // translating numeric value of the character to an index in the counting array
        // For example:
        // 'a' = 97, 'b' = 98, ...
        // therefore, 'b' index won't be 98, and should be 98-97 = 1 in the countArray
    }

}
