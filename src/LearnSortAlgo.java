public class LearnSortAlgo {

    public static void print() {
        System.out.println("--Learn Sort Algo--");
    }

    public static void bubbleSortExample() {
        System.out.println(" --- Bubble Sort --- ");
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        // <method 1>:
        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[i+1]) {
                    swap(intArray, i, i+1);
                }
            }
        }

        // <method 2>:
//        int lastUnsortedIndex = intArray.length - 1;
//        while (lastUnsortedIndex > 0) {
//            for (int i = 0; i < intArray.length-1; i++) {
//                if (intArray[i] > intArray[i+1]) {
//                    swap(intArray, i, i+1);
//                }
//            }
//            lastUnsortedIndex--;
//        }

        for (int num : intArray) {
            System.out.println(num);
        }
    }


    public static void selectionSortExample() {
        System.out.println(" --- Selection Sort --- ");
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largest = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++) {
                // NOTES:
                // unlike Bubble sort, we do need to check the element in the last position here
                // Bubble sort is comparing i with i+1, so the last we want to check is lastUnsotedIndex - 1 for Bubble sort
                if (intArray[i] > intArray[largest]) {
                    largest = i;
                }
            }
            swap(intArray, largest, lastUnsortedIndex);
        }

        for (int num : intArray) {
            System.out.println(num);
        }
    }

    public static void insertionSortExample() {
        System.out.println(" --- Insertion Sort --- ");
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        // outer loop growing the sorted partition by one
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {
            int newElement = intArray[firstUnsortedIndex];
            int i;

            // inner loop is looking for the correct position to insert each element and do the shifting
            for (i = firstUnsortedIndex; i > 0 && intArray[i-1] > newElement; i--) {
                // i > 0: the moment we hit the front of the array
                // intArray[i-1] > newElement: the moment we hit an element that is less than or equal to the element we are trying to insert
                // Example:
                // when i=2: is i > 0? yes
                // is int[2-1] > -15? yes 35>-15
                // then switch -15 to 35 ==> {20, 35, 35, 7, 55, 1, -22}
                intArray[i] = intArray[i-1];
            }
            intArray[i] = newElement;
        }

        for (int num : intArray) {
            System.out.println(num);
        }
    }
    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
