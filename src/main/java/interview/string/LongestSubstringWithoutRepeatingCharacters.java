package interview.string;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>Longest Substring Without Repeating Characters</b>
 * <p></p>
 * Given a string s, find the length of the longest
 * substring without repeating characters.
 * <p></p>
 * <b>Example 1:</b>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p></p>
 * <b>Example 2:</b>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p></p>
 * <b>Example 3:</b>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String input = "pwwkew"; // bbbbb pwwkew
        int answer = lengthOfLongestSubstring(input);
        System.out.println("Answer: " + answer);
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (map.containsKey(c) && map.get(c) >= i) {
                i = map.get(c) + 1;
            }
            int currWindow = j - i + 1;
            max = Math.max(currWindow, max);
            map.put(c, j);
        }
        return max;
    }
}
