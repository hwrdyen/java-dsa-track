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

    public static void shellSortExample() {
        System.out.println(" --- Shell Sort --- ");
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for (int gap = intArray.length / 2; gap > 0; gap /= 2) { // gap-iteration
            for (int i = gap; i < intArray.length; i++) {
                int newElement = intArray[i];
                int j = i;
                while (j >= gap && intArray[j - gap] > newElement) {
                    intArray[j] = intArray[j - gap];
                    j -= gap;
                }

                intArray[j] = newElement;
            }
        }

        for (int num : intArray) {
            System.out.println(num);
        }
    }

    // recursion:
    // 1! = 1 * 0! = 1
    // 2! = 2 * 1 = 2 * 1!
    // 3! = 3 * 2 * 1 = 3 * 2!
    // 4! = 4 * 3 * 2 * 1 = 4 * 3!
    // n! = n * (n-1)!
    public static int recursiveFactorial(int num) {
        if (num == 0) {
            return 1;
        } // breaking condition / base case is required to unwind!

        // Ex.
        // num = 3
        // "call stack" will look like -->
        // step 1. recursiveFactorial(3)
        // step 2. recursiveFactorial(2)
        //         recursiveFactorial(3)
        // step 3. recursiveFactorial(1)
        //         recursiveFactorial(2)
        //         recursiveFactorial(3)
        // then recursiveFactorial(0) return 1, recursiveFactorial(1) got popped off the call stack
        // step 4. recursiveFactorial(2)
        //         recursiveFactorial(3)
        // step 5. recursiveFactorial(3)
        // return value

        return num * recursiveFactorial(num - 1);
    }

    // not using recursive implementation:
    public static int iterativeFactorial (int num) {
        if (num == 0) {
            return 1;
        }

        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }

        // Exx.
        // num = 3
        // inside for-loop:
        //      int i = 1 ==> factorial * 1 = 1
        //      int i = 2 ==> factorial * 2 = 1 * 2 = 2
        //      int i = 3 ==> factorial * 3 = 2 * 3 = 6
        // ==> num = 3, factorial = 6

        return factorial;
    }

    public static void mergeSortExample() {
        System.out.println(" --- Merge Sort --- ");
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        mergeSort(intArray, 0, intArray.length);

        for (int num : intArray) {
            System.out.println(num);
        }
    }
    public static void mergeSort(int[] input, int start, int end) {
        // end is always one grader than the last valid index of the partition that you wanna sort
        if (end - start < 2) {
            return; // if we only have a one element array, then break the recursion
        }

        int mid = (start + end) / 2; // partition the array

        mergeSort(input, start, mid); // complete process the left side
        mergeSort(input, mid, end); // complete process the right side
        merge(input, start, mid, end); // By the time we call this merge, the left and right partition have been fully handled (partitioned and merged)
    }

    public static void merge(int[] input, int start, int mid, int end) {
        // 1st optimization:
        if (input[mid - 1] <= input[mid]) {
            return;
            // mid is the first element in the right side
            // it's one greater than the last element in the left side
            // input[mid - 1]: last element in the left partition
            // input[mid]: first element in the right partition
            // if (input[mid - 1] <= input[mid]) then all element on the left side is smaller than the right side because both array are sorted already
        }

        // Merge Process
        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        // 2nd optimization:
        // we don't need to worry about the last element that is left inside the right array
        // because {32, 34}, {33, 36} ==> {32, 33, 34} and 36 is left, but it is still the largest and the index position will not changed
        // but this is not the case for the last element that is left inside the left array
        // for example: {32, 36}, {33, 34} ==> {32, 33, 34, 36} and 36 is required to be put inside the temp array because the position index isn't same as its original index
        System.arraycopy(input, i, input, start+tempIndex, mid-i);
        // we dont copy any left-over elements in the "left" partition into the temp array, we copy directly into where they end up in the input array
        // if there's left-over elements in the "right" partition, then we dont do anything

        // back to Merge Process
        System.arraycopy(temp, 0, input, start, tempIndex);
    }

    public static void quickSortExample() {
        System.out.println(" --- Quick Sort --- ");
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        quickSort(intArray, 0, intArray.length);

        for (int num : intArray) {
            System.out.println(num);
        }
    }

    public static void quickSort(int[] input, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int pivotIndex = partition(input, start, end); // return the position element in the sorted array, in other words -- position at the pivot
        quickSort(input, start, pivotIndex);
        quickSort(input, pivotIndex+1, end);
    }

    public static int partition(int[] input, int start, int end) {
        // This is using the first element as the pivot
        int pivot = input[start];
        int i = start;
        int j = end;

        while (i < j) {

            // NOTE: Empty loop body
            while (i < j && input[--j] >= pivot); // NOTE: [--j] is prefix increment operator ==> when we execute this statement, we'll decrement j first and use the result
            if (i < j) {
                input[i] = input[j];
            }

            while (i < j && input[++i] <= pivot); // NOTE: the while loop has a semicolon (;) at the end, making it an empty loop. The loop increments i while the condition i < j && input[++i] <= pivot holds, but it doesn't execute any code inside the loop body. After the loop finishes, if i < j is still true, only then the assignment input[j] = input[i]; will occur once.
            if (i < j) {
                input[j] = input[i];
            }

        }

        input[j] = pivot;
        return j;
    }

    public static void countingSortExample() {
        int[] intArray = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};

        countingSort(intArray, 1, 10);

        for (int num: intArray) {
            System.out.println(num);
        }
    }

    public static void countingSort(int[] input, int min, int max) {
        int[] countArray = new int[(max-min) + 1]; // assume min=1; max=10, then (max-min) + 1 = 10 ==> equals to possible 10 values

        for (int i = 0; i < input.length; i++) {
            countArray[input[i] - min]++; //input[i] - min: need to transfer value from 10 to 20 --> indicies 0 to 10
        }

        int j = 0;
        for (int i = min; i <= max; i++) {
            while(countArray[i - min] > 0) {
                input[j++] = i;
                countArray[i - min] --;
            }
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
