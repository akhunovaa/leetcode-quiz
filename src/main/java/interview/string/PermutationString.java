package interview.string;

import java.util.Arrays;

/**
 * <b>Permutation in String</b>
 * <p></p>
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 * <p></p>
 * <b>Example 1:</b>
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * <p></p>
 * <b>Example 2:</b>
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 */
public class PermutationString {

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        boolean answer = checkInclusion(s1, s2);
        System.out.println("Answer: " + answer);
    }

    public static boolean checkInclusion(String s1, String s2) {

//        char[] newStr = new char[s.length() * 2 + 1];
//        newStr[0] = '#';
//        for (int i = 0; i < s.length(); i++) {
//            newStr[2 * i + 1] = s.charAt(i);
//            newStr[2 * i + 2] = '#';
//        }

        int n = s1.length(), m = s2.length();
        int[] f = new int[26];
        for (int i = 0; i < n; i++) {
            f[s1.charAt(i) - 'a']++;
        }
        int[] g = new int[26];
        for (int i = 0; i < m; i++) {
            g[s2.charAt(i) - 'a']++;
            if (i >= n) {
                g[s2.charAt(i - n) - 'a']--;
            }
            if (Arrays.equals(f, g)) return true;
        }
        return false;
    }

}
