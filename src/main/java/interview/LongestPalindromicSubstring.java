package interview;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String input = "babad"; // babad => bab; cbbd => "bb"
        String answer = longestPalindrome(input);
        System.out.println("Answer: " + answer);
    }

    public static String longestPalindrome(String s) {
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
