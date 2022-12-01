package interview.string;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String input = "babad"; // babad => bab; cbbd => "bb"
        String answer = longestPalindrome(input);
        System.out.println("Answer: " + answer);
    }

    static String longestPalindrome(String s) {
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
