package interview.string;


/**
 * <b>Valid Anagram</b>
 * <p></p>
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise. An Anagram is a word or phrase
 * formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * <p></p>
 * <b>Example 1:</b>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * <p></p>
 * <b>Example 2:</b>
 * Input: s = "rat", t = "car"
 * Output: false
 */
public class ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        boolean answer = isAnagram(s, t);
        System.out.println("Answer: " + answer);
    }

    public static boolean isAnagram(String s, String t) {
        // Base case: if the two strings are empty...
        if(s == null || t == null) return false;
        // In case of different length of those two string...
        if(s.length() != t.length()) return false;
        // To count freq we make an array of size 26...
        int[] counter = new int[26];
        // Traverse all elements through a loop...
        for(int idx = 0; idx < s.length(); idx++){
            counter[s.charAt(idx)-'a'] = counter[s.charAt(idx)-'a'] + 1;
            counter[t.charAt(idx)-'a'] = counter[t.charAt(idx)-'a'] - 1;;
        }
        // Above iteration provides us with count array having all values to zero then we can say we found an anagram.
        // Every element of count has to be equal to 0.
        // If it is greater than 0 it means s has a character whose occurrence is greater than its occurrence in t.
        // And if its less than 0 then, s has a character whose occurrence is smaller than its occurrence in t.
        for(int idx: counter){
            if(idx != 0)
                return false;
        }
        return true;
    }

}
