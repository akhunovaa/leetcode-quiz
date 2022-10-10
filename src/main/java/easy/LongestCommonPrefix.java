package easy;

/*
    Input: strs = ["flower","flow","flight"]
    Output: "fl"

    Input: strs = ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] input = {"flower", "flow", "flight"};
        String answer = longestCommonPrefix(input);
        System.out.println(answer);
    }

    /*
    Time complexity : O(S)
where S is the sum of all characters in all strings. In the worst case all n strings are the same.
    Space complexity : O(1)
We only used constant extra space.
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    public String longestCommonPrefix3(String[] strs) {
        /* Set a condition to check for null or empty strings */
        if (strs == null || strs.length == 0) {
            return "";
        }
        /* create 2 loops, set my first loop to get # of strings and set pos at 0*/
        for (int i = 0; i < strs[0].length(); i++) {
            /*this sets c as a temp val to check other strings chars for similar letters*/
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                /* if i equals the max length loop ends or if string doesnt match C it ends */
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    /* then it returns the substring of similiar char*/
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

}
