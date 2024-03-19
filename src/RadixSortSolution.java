import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RadixSortSolution {
    /**
     * Time Complexity: O(M * N) where N is the length of the shortest string of the input and M is the total number
     * of strings in the input. The two for loops, one before and one after the radix sort passes, are both O(M).
     * However, they are less significant and we only consider the radix passes for their complexity. For that loop, there are
     * N passes in total. For each pass, we iterate through all strings M times to distribute them into buckets based
     * on the current character position. Hence, O(M*N).
     *
     * Space Complexity: Creating a HashMap of size N, where N is the amount of Strings in the input array, yields a
     * space complexity of O(N).
     *
     * Space Complexity:
     * @param inputArray
     */
    public void lexoSort(String[] inputArray) {
        int minCount = 0;
        int count;

        // Convert all strings to lowercase and find the length of the shortest string
        for (String x : inputArray) {
            x = x.toLowerCase();
            count = x.length(); // find shortest String
            if (count < minCount || minCount == 0) {
                minCount = count;
            }
        }

        // Radix sort passes
        for (int i = minCount - 1; i >= 0; i--) { // Start from the least significant character of shortest string
            // Initialize HashMap for each character position (a-z)
            Map<Character, ArrayList<String>> buckets = new HashMap<>();
            for (char c = 'a'; c <= 'z'; c++) {
                buckets.put(c, new ArrayList<>());
            }

            // Distribute elements into buckets based on the current character position
            for (String x : inputArray) {
                char c = x.charAt(i); // Get the character at the current position
                buckets.get(c).add(x); // Add the string to the corresponding bucket
            }

            // Concatenate elements from buckets back into inputArray
            int index = 0;
            for (char c = 'a'; c <= 'z'; c++) {
                for (String str : buckets.get(c)) {
                    inputArray[index++] = str;
                }
            }
        }
        for(String x : inputArray){
            System.out.println(x);
        }
    }

    public static void main (String[] args){
        RadixSortSolution r = new RadixSortSolution();
        String[] input = {"gojo", "google", "jogo", "bill", "pup", "cipher", "watchmen", "knight", "it", "stand", "sandman",
                "hydra", "surtr"};
        r.lexoSort(input);
    }

}
