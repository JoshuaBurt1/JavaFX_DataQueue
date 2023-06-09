package joshuaburt_sec005_ex01;


/*
Exercise 01: This is based on the HashMap and extension to app – WordTypeCount.java
(refer code examples-based on Collections posted on Blackboard) demonstrated in the class. It gives the following output.
You need to enhance the above example to find and display the duplicate words i.e. those repeated minimum and maximum number of times.
So, based on the sample input string above, output should be:
a – 2
of -- 4
 */
import java.util.*;

public class Exercise1 {
    public static void main(String[] args) {
        // create HashMap to store String keys and Integer values
        Map<String, Integer> myMap = new HashMap<>();

        createMap(myMap); // create map based on user input
        displayMap(myMap); // display map content
    }

    // create map from user input
    private static void createMap(Map<String, Integer> map) {
        //If user wants to enter a custom String
        //Scanner scanner = new Scanner(System.in); // create scanner
        //System.out.println("Test a string? (yes or no): "); // prompt for user input
        //String input = scanner.nextLine();
        String input = "This is a a demo demo demo of of of of collections in java";
        // tokenize the input
        String[] tokens = input.split(" ");

        // processing input text
        for (String token : tokens) {
            String word = token.toLowerCase(); // get lowercase word

            // if the map contains the word
            if (map.containsKey(word)) { // is word in map?
                int count = map.get(word); // get current count
                map.put(word, count + 1); // increment count
            }
            else {
                map.put(word, 1); // add new word with a count of 1 to map
            }
        }
    }

    // display map content
    private static void displayMap(Map<String, Integer> map) {
        Set<String> keys = map.keySet(); // get keys

        // sort keys
        TreeSet<String> sortedKeys = new TreeSet<>(keys);

        System.out.printf("%nMap contains:%nKey\t\tValue%n");

        // generate output for each key in map
        String y = "";
        int x = 0;
        int max = 0;
        String maxKey = "";
        int min = 0;
        String minKey = "";
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<Integer> maxNumbers = new ArrayList<Integer>();
        ArrayList<String> maxWords = new ArrayList<String>();
        ArrayList<Integer> minNumbers = new ArrayList<Integer>();
        ArrayList<String> minWords = new ArrayList<String>();
        for (String key : sortedKeys) {
            y = key;
            x = map.get(key);
            System.out.printf("%-10s%10s%n", key, map.get(key));
            if(x>1) { //finds occurrence of repeat
                numbers.add(x);
                words.add(y);
                if (x >= max) { //finds a new maximum
                    max = x;
                    maxNumbers.add(max); //maximum repeat number added to maxNumbers array
                    maxKey = y;
                    maxWords.add(maxKey); //associated maximum repeat word added to maxWords array
                    for(int i = 0; i< maxNumbers.size(); i++) {
                        while (max > maxNumbers.get(i)) { //maxNumbers array is always the same max numbers and associated word
                            maxNumbers.remove(maxNumbers.get(0));
                            maxWords.remove(maxWords.get(0));
                        }
                    }
                }
                Collections.sort(numbers);
                if(numbers.get(0) == x){ //finds a new minimum
                    min = x;
                    minNumbers.add(min); //minimum repeat number added to minNumbers array
                    minKey = y;
                    minWords.add(minKey); //associated minimum repeat word added to minWords array
                    for(int i = 0; i< minNumbers.size(); i++) {
                        while (min < minNumbers.get(i)) { //minNumbers array is always the same min numbers and associated word
                            minNumbers.remove(minNumbers.get(i));
                            minWords.remove(minWords.get(i));
                        }
                    }
                }
            }
        }
        System.out.println();
        System.out.println("Maximums:");
        for (int i = 0; i< maxNumbers.size(); i++){
            System.out.println(maxWords.get(i)+ " - " +maxNumbers.get(i));
        }
        System.out.println("Minimums:");
        for (int i = 0; i< minNumbers.size(); i++){
            System.out.println(minWords.get(i)+ " - " +minNumbers.get(i));
        }
        System.out.printf(
                "%nsize: %d%nisEmpty: %b%n", map.size(), map.isEmpty());
        System.out.println();
    }
}
