package interview.string;

import java.util.Stack;

/**
 * <b>Backspace String Compare</b>
 * <p></p>
 * Given two strings s and t, return true if they are equal when both are typed into
 * empty text editors. '#' means a backspace character.
 * Note that after backspacing an empty text, the text will continue empty.
 * <p></p>
 * <b>Example 1:</b>
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * <p></p>
 * <b>Example 2:</b>
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * <p></p>
 * <b>Example 3:</b>
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 */
public class BackspaceStringCompare {

    public static void main(String[] args) {
        String s = "ab#c", t = "ad#c";
        boolean answer = backspaceCompare(s, t);
        System.out.println("Answer: " + answer);
    }

    // Time Complexity: O(M+N), where M and N are the lengths of S and T respectively
    // Space Complexity: O(M+N) (c) Azat A. Akhunov
    public static boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    public static String build(String str) {
        Stack<Character> ans = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }

    // Time Complexity: O(M+N), where M and NM are the lengths of s and t respectively
    // Space Complexity: O(1) (c) Azat A. Akhunov
    public static boolean secondBackspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int skipS = 0, skipT = 0;
        // while there may be chars in s or t
        while (i >= 0 || j >= 0) {
            // find position of next possible char in s
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else break;
            }
            // find position of next possible char in t
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else break;
            }
            // if two actual characters are different in idx = 0
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j))
                return false;
            // if expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--;
            j--;
        }
        return true;
    }
}
