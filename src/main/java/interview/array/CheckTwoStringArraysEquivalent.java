package interview.array;

public class CheckTwoStringArraysEquivalent {

    public static void main(String[] args) {
        String[] word1 = {"a", "cb"};
        String[] word2 = {"ab", "c"};
        boolean answer = arrayStringsAreEqual(word1, word2);
        System.out.println("Answer: " + answer);
    }

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
