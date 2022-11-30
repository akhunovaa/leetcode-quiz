package interview.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <b>Longest Palindrome</b>
 * <p></p>
 * Given a string s which consists of lowercase or uppercase letters, return the length
 * of the longest palindrome that can be built with those letters.
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 * <p></p>
 * <b>Example 1:</b>
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 * <p></p>
 * <b>Example 2:</b>
 * Input: s = "a"
 * Output: 1
 * Explanation: The longest palindrome that can be built is "a", whose length is 1.
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "abccccdd"; // dccaccd
        int answer = setLongestPalindrome(s);
        System.out.println("Answer: " + answer);
//
//        answer = longestPalindrome(new String[] {"ab","ty","yt","lc","cl","ab"}); // ab cl lc yt ty ab // ab ab yt ty cl lc
//        System.out.println("Answer: " + answer);
    }

    public static int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2; //  5 / 2 * 2 = 4  => v / 2 * 2
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }
        return ans;
    }

    public static int longestPalindrome(String[] words) {
        HashMap<String, Integer> count = new HashMap<>();
        for (String word : words) {
            Integer countOfTheWord = count.get(word);
            if (countOfTheWord == null) {
                count.put(word, 1);
            } else {
                count.put(word, countOfTheWord + 1);
            }
        }
        int answer = 0;
        boolean central = false;
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            String word = entry.getKey();
            int countOfTheWord = entry.getValue();
            // if the word is a palindrome
            if (word.charAt(0) == word.charAt(1)) {
                if (countOfTheWord % 2 == 0) {
                    answer += countOfTheWord;
                } else {
                    answer += countOfTheWord - 1;
                    central = true;
                }
                // consider a pair of non-palindrome words such that one is the reverse of another
            } else if (word.charAt(0) < word.charAt(1)) {
                String reversedWord = "" + word.charAt(1) + word.charAt(0);
                if (count.containsKey(reversedWord)) {
                    answer += 2 * Math.min(countOfTheWord, count.get(reversedWord));
                }
            }
        }
        if (central) {
            answer++;
        }
        return 2 * answer;
    }

    // данный способ перебирает все символы из строки и при следующем нахождении идентичного символа, удаляет из Set
    // таким образом в Set остаются все символы, у которых нет пары в строке
    // и после вычитаем кол-во таких символов из кол-ва символов входной строки
    // получая в ответе число из которых возможен палиндром входящей строки
    public static int setLongestPalindrome(String s) {
        if (s == null || s.length() < 1) return 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i)))
                set.remove(s.charAt(i));
            else
                set.add(s.charAt(i));
        }
        if (set.size() <= 1) {
            return s.length();
        }
        return s.length() - set.size() + 1;
    }

}
