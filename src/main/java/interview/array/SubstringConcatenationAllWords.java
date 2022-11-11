package interview.array;

import java.util.*;

public class SubstringConcatenationAllWords {

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        List<Integer> answer = findSubstring(s, words);
        System.out.println("Answer: " + answer);
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indices = new ArrayList<>();
        Map<String, Integer> wordsMap = new HashMap<>();
        Arrays.stream(words).forEach(word -> wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1));

        int wordLength = words[0].length(), count = words.length;
        for (int index = 0; index <= s.length() - wordLength * count; ++index) {
            if (isContainsAllWords(wordsMap, s.substring(index, index + wordLength * count), wordLength))
                indices.add(index);
        }

        return indices;
    }

    private static boolean isContainsAllWords(Map<String, Integer> wordsMap, String substring, int wordLength) {
        Map<String, Integer> substringWordsMap = new HashMap<>();
        for (int i = 0; i < substring.length(); i += wordLength) {
            String word = substring.substring(i, i + wordLength);
            substringWordsMap.put(word, substringWordsMap.getOrDefault(word, 0) + 1);

            if (substringWordsMap.get(word) > wordsMap.getOrDefault(word, 0))
                return false;
        }
        return substringWordsMap.equals(wordsMap);
    }

}
