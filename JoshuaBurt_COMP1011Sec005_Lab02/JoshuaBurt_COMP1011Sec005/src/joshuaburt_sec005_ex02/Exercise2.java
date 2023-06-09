package joshuaburt_sec005_ex02;


import java.util.Scanner;

/*
Exercise 02: Write an overloaded generic method which prints a double array, string array and character array as shown below:
Sample arrays are:
Double [ ] grades = { 56.7, 89.23, 45.56, 88.40, 90.56 }
String[ ] product = { “iphone”, “Galaxy”, “Pixel”, “Nokia”}
Char[ ] status = { ‘y’, ‘n’, ‘i’, ‘d’, ‘e’ }
Overloaded methods definitions:
public static <T> void printArray(T[] inputArray) { …} // version 1.0
public static <T> void printArray(T[] inputArray, int startIndex) { …} // version 2.0
Add validation for startIndex such as it can not be negative or higher than the size of the array
public static <T> void printArray(T[] inputArray, int startIndex, int endIndex) { …} // version 3.0
Add validations such as both the indices should be non-negative and startIndex should be smaller than endIndex.
* */
public class Exercise2 {
    public static void main(String[] args) {
        Double[] doubleArray = {3.18, 6.12, 23.68, 196.9, 49.0};
        String[] stringArray = {"Sun", "Moon", "ManInBlack", "Gold", "King"};
        Character[] characterArray = {'S', 'M', 'M', 'G', 'K'};

        System.out.println("Version 1");
        System.out.printf("Array doubleArray contains: ");
        printArray1(doubleArray); // pass a Double array
        System.out.printf("Array stringArray contains: ");
        printArray1(stringArray); // pass a String array
        System.out.printf("Array characterArray contains: ");
        printArray1(characterArray); // pass a Character array
        System.out.println("");

        System.out.println("Version 2");
        System.out.printf("Array doubleArray contains: ");
        printArray2(doubleArray,1); // pass a Double array
        System.out.printf("Array stringArray contains: ");
        printArray2(stringArray,1); // pass a String array
        System.out.printf("Array characterArray contains: ");
        printArray2(characterArray,1); // pass a Character array
        System.out.println("");

        System.out.println("Version 3");
        System.out.printf("Array doubleArray contains: ");
        printArray3(doubleArray,1,3); // pass a Double array
        System.out.printf("Array stringArray contains: ");
        printArray3(stringArray,1,3); // pass a String array
        System.out.printf("Array characterArray contains: ");
        printArray3(characterArray,1,3); // pass a Character array
        System.out.println("");

        // use scanner to allow for user to input array
        // create arrays of Double and Character
        Scanner scanner = new Scanner(System.in); // create scanner
        System.out.println("Enter a series of string values separated by a space: "); // prompt for user input
        String input1 = scanner.nextLine();
        String[] stringArrayUser = input1.split(" ");

        Scanner startIndexScan = new Scanner(System.in); // create scanner
        System.out.println("Enter start index (int): "); // prompt for user input
        int input2 = Integer.valueOf(startIndexScan.nextLine());

        Scanner endIndexScan = new Scanner(System.in); // create scanner
        System.out.println("Enter end index (int): "); // prompt for user input
        int input3 = Integer.valueOf(endIndexScan.nextLine());

        printArray3(stringArrayUser,input2,input3); // pass a String array
    }

    //Version 1.0
    public static <T> void printArray1(T[] inputArray) { //prints all elements in doubleArray, stringArray, characterArray
        for (T element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    //Version 2.0 --  Add validation for startIndex such as it can not be negative or higher than the size of the array
    public static <T> void printArray2(T[] inputArray, int startIndex) { //prints all elements in doubleArray, stringArray, characterArray starting from start index
        if(startIndex>=0 && startIndex<=inputArray.length) { //validation: startIndex must be greater than or 0 and less than array length
            int i = 0;
            for (T element : inputArray) {
                i++;
                if (i > startIndex) { //if iteration value i is greater than start index, begin for loop printing elements at index
                    System.out.printf("%s ", element);
                }
            }
            System.out.println();
        }
        else{
            throw new IllegalArgumentException("startIndex can not be negative or higher than the size of the array");
        }
    }

    //Version 3.0 -- Add validations such as both the indices should be non-negative and startIndex should be smaller than endIndex.
    public static <T> void printArray3(T[] inputArray, int startIndex, int endIndex){ //prints all elements in doubleArray, stringArray, characterArray starting from start index and ending at endIndex
        if(startIndex>=0 && endIndex>0 && startIndex<endIndex && startIndex<inputArray.length && endIndex<=inputArray.length) { //validation: startIndex must be greater than or 0, end index must be greater than 0, start index must be less than endIndex, startIndex must be less than array length, and endIndex must be less than or equal to array length
            int i = 0;
            for (T element : inputArray) {
                i++;
                if (i > startIndex && i <= endIndex) { //if iteration value i is greater than start index and less than endIndex, print elements
                    System.out.printf("%s ", element);
                }
            }
            System.out.println();
        }
        else{
            throw new IllegalArgumentException("startIndex and endIndex can not be negative or higher than the size of the array; startIndex must be less than endIndex");
        }
    }
}

// Original overloaded printArray method:
//        public static  void printArray(String[] inputArray) {
//            // display array elements
//            for (String element : inputArray) {
//                System.out.printf("%s ", element);
//            }
//            System.out.println();
//        }
//
//        // method printArray to print Double array
//        public static void printArray(Double[] inputArray) {
//            // display array elements
//            for (Double element : inputArray) {
//                System.out.printf("%s ", element);
//            }
//            System.out.println();
//        }
//
//        // method printArray to print Character array
//        public static void printArray(Character[] inputArray) {
//            // display array elements
//            for (Character element : inputArray) {
//                System.out.printf("%s ", element);
//            }
//            System.out.println();
//        }