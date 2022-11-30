package interview.string;

import java.util.ArrayList;
import java.util.List;

public class CellsRangeExcelSheet {

    public static void main(String[] args) {
        String s = "U7:X9";
        List<String> answer = cellsInRange(s);
        System.out.println("Answer: " + answer);
    }


    static List<String> cellsInRange(String s) {
        List<String> answerList = new ArrayList<>();
        int startLetter, startNumber, endLetter, endNumber;
        char[] charArray = s.toCharArray();
        startLetter = charArray[0];
        startNumber = Character.getNumericValue(charArray[1]);
        endLetter = charArray[3];
        endNumber = Character.getNumericValue(charArray[4]);
        for(int i = startLetter; i <= endLetter; i++) {
            String letter = String.valueOf((char) i);
            for (int j = startNumber; j <= endNumber; j++) {
                answerList.add(letter + j);
            }
        }
        return answerList;
    }
}
