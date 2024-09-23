public class LearnArray {

    public static void print() {
        System.out.println("--Learn Array--");
    }

    public static void arrayExample() {
        System.out.println("arrayExample 1:");
        // NOTES: Array need to specify size (not dynamic)
        int[] intArray = new int[7];
        intArray[0] = 20;
        intArray[1] = 35;
        intArray[2] = -15;
        intArray[3] = 7;
        intArray[4] = 55;
        intArray[5] = 1;
        intArray[6] = -22;

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }

//        for (int i: intArray) {
//            System.out.println(i);
//        }

        // search elements = 7
        System.out.println("arrayExample 2:");
        int index = -1;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == 7) {
                index = i;
                break;
            }
        }
        System.out.println("index = " + index);
        // worst case:
        // would be 7 is the last item in the array,
        // so we have to search for the whole array to find 7
        // then we have to loop intArray.length times
    }

}
