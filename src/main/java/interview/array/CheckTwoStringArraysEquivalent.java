package interview.array;

//1662. Check If Two String Arrays are Equivalent
public class CheckTwoStringArraysEquivalent {

    public static void main(String[] args) {
        String[] word1 = {"a", "bc"};
        String[] word2 = {"ab", "c"};
        boolean answer = arrayStringsAreEqualTwoPointers(word1, word2);
        System.out.println("Answer: " + answer);
    }

    // Approach 2: Two Pointers
    static boolean arrayStringsAreEqualTwoPointers(String[] word1, String[] word2) {
        // pointers to mark the current word in the given two lists.
        int word1Pointer = 0, word2Pointer = 0;
        // Pointers to mark the character in the string pointed by the above pointers.
        int string1Pointer = 0, string2Pointer = 0;

        // while we still have the string in any of the two given lists.
        while (word1Pointer < word1.length && word2Pointer < word2.length) {

            // if the characters at the two string are same, increment the string pointers
            // otherwise return false.
            if (word1[word1Pointer].charAt(string1Pointer++) !=
                    word2[word2Pointer].charAt(string2Pointer++)) {
                return false;
            }

            // if the string pointer reaches the end of string in the list word1,
            // move to the next string in the list and, reset the string pointer to 0.
            if (string1Pointer == word1[word1Pointer].length()) {
                word1Pointer++;
                string1Pointer = 0;
            }

            // if the string pointer reaches the end of string in the list word2,
            // move to the next string in the list and, reset the string pointer to 0.
            if (string2Pointer == word2[word2Pointer].length()) {
                word2Pointer++;
                string2Pointer = 0;
            }
        }
        // strings in both the lists should be traversed.
        return word1Pointer == word1.length && word2Pointer == word2.length;
    }

    // Approach 1: Concatenate and Compare
    static boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < word1.length; i++) {
            sb1.append(word1[i]);
        }

        for (int i = 0; i < word2.length; i++) {
            sb2.append(word2[i]);
        }

        String s = sb1.toString();
        String t = sb2.toString();
        return s.equals(t);
    }

}
