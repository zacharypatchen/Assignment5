import java.util.HashMap;

public class SubIntegerSolution {
    /**
     * Time Complexity: O(N+M), where N and M are the input integer arrays S & T. Filling the Hashmap with T takes
     * O(M) times. This is added to the O(N) complexity of iterating through S N-times to compare with the Hashmap.
     *
     * Space Complexity: T is stored to a Hashmap, so O(M), where M is the number of ints in T.
     *
     * @param S
     * @param T
     * @return Yes or No
     */
    public String isSubset(int[] S, int[] T) {
        // Create a hash table to store the elements of set T
        HashMap<Integer, Boolean> hashMap = new HashMap<>();

        // Add elements of set T to the hash table
        for (int num : T) {
            hashMap.put(num, true);
        }

        // Check if all elements of set S are present in set T
        for (int num : S) {
            if (!hashMap.containsKey(num)) {
                return "No"; // S is not a subset of T
            }
        }

        return "Yes"; // S is a subset of T
    }
    public static void main(String[] args){
        SubIntegerSolution sis = new SubIntegerSolution();
        int[] S = {32, 3};
        int[] T = {1, 2, 3, 52, 32, 54};
        System.out.println(sis.isSubset(S,T));
    }
}
