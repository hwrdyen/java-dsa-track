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
}
