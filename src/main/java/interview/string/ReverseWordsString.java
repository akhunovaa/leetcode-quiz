package interview.string;

/**
 * <b>Reverse Words in a String III</b>
 * <p></p>
 * Given a string s, reverse the order of characters in each word within a
 * sentence while still preserving whitespace and initial word order.
 * <p></p>
 * <b>Example 1:</b>
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * <p></p>
 * <b>Example 2:</b>
 * Input: s = "God Ding"
 * Output: "doG gniD"
 */
public class ReverseWordsString {

    public static void main(String[] args) {
        String input = "Let's take LeetCode contest";
        String answer = reverseWords(input);
        System.out.println("Answer: " + answer);
    }

    // Time Complexity: O(N/2) => O(N+N) = O(N)
    // Space Complexity: O(1) => we use constant extra space to track the last space index
    static String reverseWords(String s) {
        int lastSpaceIndex = -1;
        char[] chArray = s.toCharArray();
        int len = s.length();
        for (int strIndex = 0; strIndex <= len; strIndex++) {
            // there we are checking the space char and start index
            // because after last space and last word there is no space
            // and after remove checking strIndex == len
            // this will ignore the last word => "s'teL ekat edoCteeL contest"
            if (strIndex == len || chArray[strIndex] == ' ') {
                int startIndex = lastSpaceIndex + 1;
                int endIndex = strIndex - 1;
                // reverse with XOR means that we swap array places [startIndex] <==> [endIndex]
                while (startIndex < endIndex) {
                    chArray[startIndex] ^= chArray[endIndex];
                    chArray[endIndex] ^= chArray[startIndex];
                    chArray[startIndex++] ^= chArray[endIndex--];
                }
                lastSpaceIndex = strIndex;
            }
        }
        return new String(chArray);
    }

}
