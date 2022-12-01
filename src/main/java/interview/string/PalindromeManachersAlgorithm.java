package interview.string;

public class PalindromeManachersAlgorithm {

    // Driver code
    public static void main(String[] args) {
        String text1 = "babcbabcbaccba";
        findLongestPalindromicString(text1);

        String text2 = "abaaba";
        findLongestPalindromicString(text2);

        String text3 = "abababa";
        findLongestPalindromicString(text3);

        String text4 = "abcbabcbabcba";
        findLongestPalindromicString(text4);

        String text5 = "forgeeksskeegfor";
        findLongestPalindromicString(text5);

        String text6 = "caba";
        findLongestPalindromicString(text6);

        String text7 = "abacdfgdcaba";
        findLongestPalindromicString(text7);

        String text8 = "abacdfgdcabba";
        findLongestPalindromicString(text8);

        String text9 = "abacdedcaba";
        findLongestPalindromicString(text9);
    }

    public static void findLongestPalindromicString(String text) {
        int textLength = text.length();
        if (textLength == 0) {
            return;
        }

        // Position count
        textLength = 2 * textLength + 1; // 2 * 7 + 1 = 15

        // LPS Length Array
        int[] lps = new int[textLength];
        lps[0] = 0;
        lps[1] = 1;

        // centerPosition
        int centerPosition = 1;

        // centerRightPosition
        int centerRightPosition = 2;

        // currentRightPosition = i
        int currentRightPosition = 0;

        // currentLeftPosition
        int iMirror;
        int expand = -1;
        int diff = -1;
        int maxLPSLength = 0;
        int maxLPSCenterPosition = 0;
        int start = -1;
        int end = -1;

        // Uncomment it to print LPS Length array
        // printf("%d %d ", L[0], L[1]);
//        for (currentRightPosition = 2; currentRightPosition < N; currentRightPosition++) {
//            // Get currentLeftPosition iMirror
//            // for currentRightPosition i
//            iMirror = 2 * C - currentRightPosition;
//
//            // Reset expand - means no
//            // expansion required
//            expand = 0;
//            diff = R - currentRightPosition;
//
//            // If currentRightPosition i is
//            // within centerRightPosition R
//            if (diff >= 0) {
//
//                // Case 1
//                if (L[iMirror] < diff)
//                    L[currentRightPosition] = L[iMirror];
//
//                    // Case 2
//                else if (L[iMirror] == diff && R == N - 1)
//                    L[currentRightPosition] = L[iMirror];
//
//                    // Case 3
//                else if (L[iMirror] == diff && R < N - 1) {
//                    L[i] = L[iMirror];
//
//                    // Expansion required
//                    expand = 1;
//                }
//
//                // Case 4
//                else if (L[iMirror] > diff) {
//                    L[i] = diff;
//
//                    // Expansion required
//                    expand = 1;
//                }
//            } else {
//                L[i] = 0;
//
//                // Expansion required
//                expand = 1;
//            }
//
//            if (expand == 1) {
//
//                // Attempt to expand palindrome centered
//                // at currentRightPosition i. Here for odd
//                // positions, we compare characters and
//                // if match then increment LPS Length by ONE
//                // If even position, we just increment LPS
//                // by ONE without any character comparison
//                try {
//                    while (((i + L[i]) < N &&
//                            (i - L[i]) > 0) &&
//                            (((i + L[i] + 1) % 2 == 0) ||
//                                    (text.charAt((i + L[i] + 1) / 2) ==
//                                            text.charAt((i - L[i] - 1) / 2)))) {
//                        L[i]++;
//                    }
//                } catch (Exception e) {
//                    assert true;
//                }
//            }
//
//            // Track maxLPSLength
//            if (L[i] > maxLPSLength) {
//                maxLPSLength = L[i];
//                maxLPSCenterPosition = i;
//            }
//
//            // If palindrome centered at
//            // currentRightPosition i expand
//            // beyond centerRightPosition R,
//            // adjust centerPosition C based
//            // on expanded palindrome.
//            if (i + L[i] > R) {
//                C = i;
//                R = i + L[i];
//            }
//
//            //Uncomment it to print LPS Length array
//            //System.out.print("%d ", L[i]);
//        }
//
//        start = (maxLPSCenterPosition -
//                maxLPSLength) / 2;
//        end = start + maxLPSLength - 1;
//
//        //System.out.print("start: %d end: %d\n",
//        //                  start, end);
//        System.out.print("LPS of string is " +
//                text + " : ");
//
//        for (i = start; i <= end; i++)
//            System.out.print(text.charAt(i));
//        System.out.println();
//    }
    }
}
