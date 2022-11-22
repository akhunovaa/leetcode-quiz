package interview.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <b>Decode String</b>
 * <p></p>
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string
 * inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * <p></p>
 * You may assume that the input string is always valid; there are no
 * extra white spaces, square brackets are well-formed, etc. Furthermore, you may
 * assume that the original data does not contain any digits and that digits are only
 * for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 * <p></p>
 * The test cases are generated so that the length of the output will never exceed 105.
 * <p></p>
 * <b>Example 1:</b>
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * <p></p>
 * <b>Example 2:</b>
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * <p></p>
 * <b>Example 3:</b>
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 */
public class DecodeString {

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        String answer = decodeString(s);
        System.out.println("Answer: " + answer);
    }

    public static String decodeString(String s) {
        Deque<Integer> numbers = new ArrayDeque<>();
        Deque<String> parts = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();

        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) { // construct a number
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numbers.push(num);
                num = 0;
                parts.push(word.toString()); // save previously constructed part to stack
                word.setLength(0); // clear the word
            } else if (c == ']') {
                // take a previous part, and we will append constructed word with repetitions to it
                StringBuilder wholePart = new StringBuilder(parts.pop());
                int repeat = numbers.pop();
                for (int j = 0; j < repeat; j++) {
                    wholePart.append(word);
                }
                word = wholePart;
            } else {
                word.append(c);
            }
        }
        return word.toString();
    }

}
