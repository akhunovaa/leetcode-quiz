package interview.string;

/**
 * <b>Is Subsequence</b>
 * <p></p>
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * <p></p>
 * <b>Example 1:</b>
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * <p></p>
 * <b>Example 2:</b>
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 */
public class IsSubsequence {

    public static void main(String[] args) {
        String s = "agc", t = "ahbgdc";
        boolean answer = isSubsequence(s, t);
        System.out.println("Answer: " + answer);
    }

    public static boolean isSubsequence(String s, String t) {
        int sub = 0, word = 0;
        while (sub < s.length() && word < t.length()) {
            if (s.charAt(sub) == t.charAt(word)) {
                sub++;
            }
            word++;
        }
        return sub == s.length();
    }
}
