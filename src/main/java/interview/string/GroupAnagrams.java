package interview.string;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] s = {"eat","tea","tan","ate","nat","bat"}; // [["bat"],["nat","tan"],["ate","eat","tea"]]
        List<List<String>> answer = groupAnagrams(s);
        System.out.println("Answer: " + answer);
    }

    static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    static List<List<String>> groupAnagramsTwo(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        for(int i = strs.length - 1; i >= strs.length / 2 - 1; i--) {
            if(i < 0) {
                break;
            }
            List<String> sub = new ArrayList<>();
            boolean isAnagram = false;
            boolean isAdded = false;
            for (int j = 0; j < i; j++) {
                isAnagram = isAnagram(strs[i], strs[j]);
                if(isAnagram) {
                    isAdded = true;
                    sub.add(strs[i]);
                    sub.add(strs[j]);
                }
            }
            if(!isAnagram && !isAdded) {
                sub.add(strs[i]);
            }
            answer.add(sub);
        }
        return answer;
    }

    private static boolean isAnagram(String word1, String word2) {
        if(word1.isEmpty() && word2.isEmpty()) {
            return true;
        }

        if(word1.length() != word2.length()) {
            return false;
        }

        int[] count = new int[26];

        for(int i = 0; i < word1.length(); i++){
            count[word1.charAt(i) - 'a']--;
            count[word2.charAt(i)- 'a']++;
        }

        for(int i: count){
            if(i != 0) {
                return false;
            }
        }
        return true;
    }
}
