package interview.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <b>Isomorphic Strings</b>
 * <p></p>
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving
 * the order of characters. No two characters may map to the same character, but a character may map to itself.
 * <p></p>
 * <b>Example 1:</b>
 * Input: s = "egg", t = "add"
 * Output: true
 * <p></p>
 * <b>Example 2:</b>
 * Input: s = "foo", t = "bar"
 * Output: false
 * <p></p>
 * <b>Example 3:</b>
 * Input: s = "paper", t = "title"
 * Output: true
 */
public class IsomorphicStrings {

    public static void main(String[] args) {
        String s = "foo", t = "bar";
        boolean answer = isIsomorphic(s, t);
        System.out.println("Answer: " + answer);
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Integer one = map1.put(s.charAt(i), i);
            Integer two = map2.put(t.charAt(i), i);
            if (!Objects.equals(one, two)) {
                return false;
            }
        }
        return true;
    }
}
