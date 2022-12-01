package interview.string;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String input = "babad"; // babad => bab; cbbd => "bb"
        String answer = longestPalindromeS(input);
        System.out.println("Answer: " + answer);
    }

    static String longestPalindrome(String s) {
        /* Preprocess s: insert '#' between characters, so we don't need to worry about even or odd length palindromes. */
        char[] newStr = new char[s.length() * 2 + 1];
        newStr[0] = '#';
        for (int i = 0; i < s.length(); i++) {
            newStr[2 * i + 1] = s.charAt(i);
            newStr[2 * i + 2] = '#';
        }
        /* Process newStr */
        /* dp[i] is the length of LPS centered at i */
        int[] dp = new int[newStr.length];
        /**
         * For better understanding, here we define "friend substring", or "friend":
         * "friend substring" has the largest end-index in all checked substrings that
         * are palindromes. We start at friendCenter = 0 and update it in each cycles.
         */
        int friendCenter = 0, friendRadius = 0, lpsCenter = 0, lpsRadius = 0;
        /* j is the symmetry of i with respect to friendCenter */
        int j;
        for (int i = 0; i < newStr.length; i++) {
            /* Calculate dp[i] */
            if (friendCenter + friendRadius > i) {
                /**
                 * This is the most important part of the algorithm.
                 *
                 * Normally we start from dp[i] = 1 and then try to expand dp[i] by doing brute-force palindromic
                 * checks. However, if i is in the range of friend (friendCenter + friendRadius > i), we can expect
                 * dp[i] = dp[j] because friend is a palindrome. This only works within the range of friend, so the
                 * max value of dp[i] we can trust is (friendEnd - i).
                 *
                 * Here is an example:
                 *
                 *     friendStart   j             friendCenter  i     friendEnd
                 *               |   |             |             |     |
                 * String: - - d c b a b c d - - - - - - - d c b a b c ? - - - - - - - -
                 *               [--------friend (palindrome)--------]
                 *
                 * In this example, (friendEnd - i) = 3, so we can only be certain that radius <= 3 part around i
                 * is a palindrome (i.e. "cbabc" part). We still need to check the character at "?".
                 */
                j = friendCenter - (i - friendCenter);
                dp[i] = Math.min(dp[j], (friendCenter + friendRadius) - i);
            }
            else {
                /* Calculate from scratch */
                dp[i] = 1;
            }
            /* Check palindrome and expand dp[i] */
            while (i + dp[i] < newStr.length && i - dp[i] >= 0&& newStr[i + dp[i]] == newStr[i - dp[i]])
                dp[i]++;
            /* Check if i should become the new friend */
            if (friendCenter + friendRadius < i + dp[i]) {
                friendCenter = i;
                friendRadius = dp[i];
            }
            /* Update longest palindrome */
            if (lpsRadius < dp[i]) {
                lpsCenter = i;
                lpsRadius = dp[i];
            }
        }
        return s.substring((lpsCenter - lpsRadius + 1) / 2, (lpsCenter + lpsRadius - 1) / 2);
    }

    static String longestPalindromeS(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static String longestPalindromeX(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        int len = s.length();
        int begin = 0;
        int maxLen = 0;

        for (int i = 0; i < len - maxLen / 2; i++) {
            int j = i;
            int k = i;
            while (k < len - 1 && s.charAt(k) == s.charAt(k + 1)) { // пропускаем повторяющиеся символы справа
                k++;
            }
            while (j > 0 && k < len - 1 && s.charAt(j - 1) == s.charAt(k + 1)) { // реверс левой и правой сторон
                j--;
                k++;
            }
            int newLen = k - j + 1;
            if (newLen > maxLen) {
                begin = j;
                maxLen = newLen;
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
