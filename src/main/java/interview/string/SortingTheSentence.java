package interview.string;

import java.util.HashMap;
import java.util.Map;

public class SortingTheSentence {


    public static void main(String[] args) {
       // String s = "pTY1";
        String s = "is2 sentence4 This1 a3";
        String answer = sortSentence(s);
        System.out.println("Answer: " + answer);
    }


    static String sortSentence(String s) {
        StringBuilder main = new StringBuilder();
        int start = 0;
        int end = s.length() - 1;

        Map<Integer, String> wordsMap = new HashMap<>();

        StringBuilder wordsFromStart = new StringBuilder();
        while(start < end) {
            char st = s.charAt(start);
            char ed = s.charAt(end);

            if(Character.isLetter(st)) {
                wordsFromStart.append(st);
            } else if(Character.isDigit(st)) {
                int pos = Character.getNumericValue(st);
                String word = wordsFromStart.toString();
                wordsFromStart.setLength(0);
                wordsMap.put(pos, word);
            }
            start++;

            if(Character.isDigit(ed)) {
                int pos = Character.getNumericValue(ed);
                StringBuilder tsb = new StringBuilder();
                while(ed != 32 && end >= start) {
                    ed = s.charAt(--end);
                    if(ed == 32) {
                        break;
                    }
                    tsb.append(ed);
                }
                String word = tsb.reverse().toString();
                wordsMap.put(pos, word);
            }
        }
        for(Integer key: wordsMap.keySet()) {
            String word = wordsMap.get(key);
            main.append(word);
            main.append(' ');
        }
        return main.toString().trim();
    }

}
